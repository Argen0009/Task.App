package com.example.taskapp.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentTaskBinding
import com.example.taskapp.model.Task
import com.example.taskapp.ui.home.HomeFragment

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val task = arguments?.getSerializable(HomeFragment.TASK_EDIT_KEY) as Task?
        if (task != null) {
            binding.btnSave.text = getString(R.string.title_emty_error)
            binding.title.setText(task.title)
            binding.desc.setText(task.desc)
        }
        binding.btnSave.setOnClickListener {
            if (binding.title.text.isNotBlank()) {
                if (task != null) {
                    update(task)
                } else save()
                findNavController().navigateUp()
            } else binding.title.error = getString(R.string.title_emty_error)
        }
    }

    private fun update(task: Task) {
        App.db.taskDoa().update(
            task.copy(
                title = binding.title.text.toString(),
                desc = binding.desc.text.toString()
            )
        )
    }

    private fun save() {
        val data = Task(
            title = binding.title.text.toString(),
            desc = binding.desc.text.toString()
        )
        App.db.taskDoa().insert(data)
    }

}
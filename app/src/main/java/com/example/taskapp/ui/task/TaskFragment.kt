package com.example.taskapp.ui.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskapp.databinding.FragmentTaskBinding
import com.example.taskapp.model.Task

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            val title = binding.etTitle.text.toString()
            val desc = binding.etDesc.text.toString()

            if (title.isEmpty() || desc.isEmpty()) {
                if (title.isEmpty()) {
                    binding.etTitle.error = "Please fill in this field"
                }
                if (desc.isEmpty()) {
                    binding.etDesc.error = "Please fill in this field"
                }
            } else {
                val data = Task(et_title = title, et_desc = desc)
                setFragmentResult(TASK_RESULT_KEY, bundleOf(TASK_KEY to data))
                findNavController().navigateUp()
            }
        }
    }

    companion object {
        const val TASK_RESULT_KEY = "task.result.key"
        const val TASK_KEY = "task.key"
    }
}
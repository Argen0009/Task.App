package com.example.taskapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.model.Task
import com.example.taskapp.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val adapter = TaskAdapter(this::onLongClickItem,this::onClick)

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun onLongClickItem(task: Task){
        showAlertDiolog(task)
    }

    private fun showAlertDiolog(task: Task) {
        val alertDiolog = AlertDialog.Builder(requireContext())
        alertDiolog.setTitle(task.title)
            .setMessage("Вы точно хотите удалить?")
            .setCancelable(true)
            .setPositiveButton("да"){_,_->
                App.db.taskDoa().delete(task)
                val data = App.db.taskDoa().getAll()
                adapter.addTask(data)
            }
            .setNegativeButton("Нет"){_,_-> }
            .show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Task.adapter = adapter
        val data = App.db.taskDoa().getAll()
        adapter.addTask(data)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun onClick(task: Task){
        findNavController().navigate(R.id.taskFragment, bundleOf(TASK_EDIT_KEY to task))
    }

    companion object{
        const val TASK_EDIT_KEY = "task.edit.key"
    }

}
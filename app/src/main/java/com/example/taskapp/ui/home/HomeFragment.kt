package com.example.taskapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.model.Task
import com.example.taskapp.ui.home.adapter.HomeAdapter
import com.example.taskapp.ui.task.TaskFragment
import com.example.taskapp.R

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val adapter = HomeAdapter()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.Task.adapter = adapter

        setFragmentResultListener(TaskFragment.TASK_RESULT_KEY) { _, bundle ->
            val data = bundle.getSerializable(TaskFragment.TASK_KEY)as Task
            data?.let { task -> adapter.addTask(task) }
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.taskapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View.OnLongClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.databinding.HomeItemBinding
import com.example.taskapp.model.Task

class TaskAdapter(
    val onLongClickItem:(task:Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {


    private val list = arrayListOf<Task>()
    fun addTask(tasks: List<Task>) {
        list.clear()
        list.addAll(tasks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = HomeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskViewHolder(binding)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(list[position])
    }

    inner class TaskViewHolder(private val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.et_title
            binding.tvDesc.text = task.et_desc

            itemView.setOnLongClickListener {
                onLongClickItem(task)
                true
            }

            }
        }
    }
package com.example.taskapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapp.databinding.HomeItemBinding
import com.example.taskapp.model.Task

class TaskAdapter(
    val onLongClickItem: (task: Task) -> Unit,
    val onClick: (task: Task) -> Unit,
    ) : ListAdapter<Task,TaskAdapter.TaskViewHolder>(TaskDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflace(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class TaskViewHolder(private val binding: HomeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(task: Task) {
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
            itemView.setOnLongClickListener {
                onLongClickItem(task)
                true
            }
            itemView.setOnClickListener {
                onClick(task)
                true
            }
        }
    }
}
class TaskDiffCallback : DiffUtil.ItemCallback<Task>(){
    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem.uit == newItem.uit

    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean =
        oldItem == newItem
}

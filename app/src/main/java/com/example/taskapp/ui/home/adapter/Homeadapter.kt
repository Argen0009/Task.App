package com.example.ismailov_argen_1_4.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskapp.databinding.HomeItemBinding
import com.example.taskapp.model.Task

class Homeadapter : Adapter<Homeadapter.TaskViewHolder>() {
    private val list = arrayListOf<Task>(
        Task("Argen","desc"),
        Task("ooo","alsals")

    )


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            HomeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
      return holder.bind(list [position])
    }

    inner class TaskViewHolder(private var binding: HomeItemBinding) :
        ViewHolder(binding.root) {
            fun bind(task: Task){
                binding.tvTitle.text = task.title
                binding.tvDesc.text = task.desc
            }

    }


}
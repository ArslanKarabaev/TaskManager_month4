package com.example.taskmanager_month4.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager_month4.R
import com.example.taskmanager_month4.databinding.FragmentTaskBinding
import com.example.taskmanager_month4.databinding.ItemTaskBinding
import com.example.taskmanager_month4.model.Task


class TaskAdapter: Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()
    fun setData(data: Task) {
        list.add(0,data)
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
       holder.bind(list[position])
        if(position % 2 == 0){
        holder.itemView.setBackgroundColor(Color.BLACK)
            holder.binding.tvTitle.setTextColor(Color.WHITE)
            holder.binding.tvDesc.setTextColor(Color.WHITE)
        }else {holder.itemView.setBackgroundColor(Color.WHITE)}
        }



    inner class TaskViewHolder(val binding: ItemTaskBinding) : ViewHolder(binding.root){

        fun bind (task: Task){
            binding.tvTitle.text = task.title
            binding.tvDesc.text = task.desc
        }
    }
}
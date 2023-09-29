package com.example.taskmanager_month4.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager_month4.databinding.ItemTaskBinding
import com.example.taskmanager_month4.model.Task
import kotlin.reflect.KFunction1


class TaskAdapter(val onLongClick: (Task)-> Unit): Adapter<TaskAdapter.TaskViewHolder>() {

    private val list = arrayListOf<Task>()
    fun addData(newList : List<Task>) {
        list.clear()
        list.addAll(newList)
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
            itemView.setOnLongClickListener(View.OnLongClickListener {
                onLongClick(task)
                false
            })
        }
    }
}

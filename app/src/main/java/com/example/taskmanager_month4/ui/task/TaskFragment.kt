package com.example.taskmanager_month4.ui.task

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskmanager_month4.App
import com.example.taskmanager_month4.R
import com.example.taskmanager_month4.databinding.FragmentTaskBinding
import com.example.taskmanager_month4.model.Task
import java.text.FieldPosition

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTitle.text.isEmpty()) {
                binding.etTitle.error = "Введите название"
            } else {
                val data = Task(
                    title = binding.etTitle.text.toString(),
                    desc = binding.etDesk.text.toString()
                )

                App.db.taskDao().insert(data)
                findNavController().navigateUp()
            }
        }
    }


    companion object {
        const val RESULT_KEY = "result.key"
        const val TASK_KEY = "task.key"

    }
}
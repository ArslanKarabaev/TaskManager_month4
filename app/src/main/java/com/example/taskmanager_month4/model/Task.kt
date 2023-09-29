package com.example.taskmanager_month4.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val uid:Int?=null,
    val title: String?,
    val desc: String?
) : java.io.Serializable

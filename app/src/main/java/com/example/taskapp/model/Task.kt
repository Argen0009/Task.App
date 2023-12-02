package com.example.taskapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uit:Int?= null,
    val desc: String? = null,
    val title: String? = null,
) : Serializable
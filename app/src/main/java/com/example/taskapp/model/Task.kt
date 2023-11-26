package com.example.taskapp.model

import androidx.core.content.PermissionChecker.PermissionResult
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val uit:Int?= null,
    val et_desc: String? = null,
    val et_title: String? = null,
) : Serializable {

}

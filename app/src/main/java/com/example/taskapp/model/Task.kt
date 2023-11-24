package com.example.taskapp.model

import java.io.Serializable

data class Task(
    val et_desc: String? = null,
    val et_title: String? = null,
) : Serializable {

}

package com.example.taskapp.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showTost(msg:String){
    Toast.makeText(requireContext(),msg,Toast.LENGTH_SHORT).show()
}
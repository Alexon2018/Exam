package com.example.exam.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.exam.MainActivity

class CustomFunctions() : AppCompatActivity() {

    fun startIntent() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

//    fun sum() : Int{
//        var a = 1
//        var b = 2
//        return a+b
//    }

}

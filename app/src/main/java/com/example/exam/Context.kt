package com.example.exam

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class Context : Application() {
    override fun onCreate() {
        mcontext = applicationContext
        super.onCreate()
    }
    companion object {
        @SuppressLint("StaticFieldLeak")
        var mcontext: Context? = null
    }
}
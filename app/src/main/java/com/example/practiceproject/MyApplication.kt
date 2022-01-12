package com.example.practiceproject

import android.app.Application
import com.example.practiceproject.di.DaggerRetroComponent
import com.example.practiceproject.di.RetroComponent
import com.example.practiceproject.di.RetroModule
import dagger.Component

class MyApplication:Application() {

    private lateinit var retroComponent: RetroComponent
    override fun onCreate() {
        super.onCreate()

        retroComponent = DaggerRetroComponent.builder()
            .retroModule(RetroModule())
            .build()

    }

    fun getRetroComponent(): RetroComponent {
        return retroComponent
    }
}

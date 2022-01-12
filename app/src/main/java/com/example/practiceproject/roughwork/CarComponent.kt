package com.example.practiceproject.roughwork

import com.example.practiceproject.MainActivity
import dagger.Component


@Component
interface CarComponent {
    fun getCar() : Car

    // For Field Injection
    fun inject(mainActivity: MainActivity)
}
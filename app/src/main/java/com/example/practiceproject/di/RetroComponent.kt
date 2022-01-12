package com.example.practiceproject.di

import com.example.practiceproject.MainActivityViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    RetroModule::class
])
interface RetroComponent {

    fun inject(mainActivityViewModel: MainActivityViewModel)
}
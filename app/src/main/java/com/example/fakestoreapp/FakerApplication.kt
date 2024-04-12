package com.example.fakestoreapp

import android.app.Application
import com.example.fakestoreapp.di.ApplicationComponent
import com.example.fakestoreapp.di.DaggerApplicationComponent

class FakerApplication: Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder().build()
    }
}
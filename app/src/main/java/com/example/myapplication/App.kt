package com.example.myapplication

import android.app.Application
import com.example.di.repositoriesModule
import com.example.myapplication.di.useCasesModule
import com.example.myapplication.di.viewModelsModule
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(listOf(repositoriesModule, viewModelsModule, useCasesModule))
        }
    }
}
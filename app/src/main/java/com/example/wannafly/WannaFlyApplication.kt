package com.example.wannafly

import android.app.Application
import com.example.wannafly.di.applicationModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WannaFlyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@WannaFlyApplication)
            modules(listOf(applicationModules))
        }
    }
}
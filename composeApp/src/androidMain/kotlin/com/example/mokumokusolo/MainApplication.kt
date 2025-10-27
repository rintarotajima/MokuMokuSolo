package com.example.mokumokusolo

import android.app.Application
import com.example.mokumokusolo.di.androidModule
import com.example.mokumokusolo.di.initKoin
import org.koin.android.ext.koin.androidContext

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidContext(this@MainApplication)
            modules(androidModule)
        }
    }
}
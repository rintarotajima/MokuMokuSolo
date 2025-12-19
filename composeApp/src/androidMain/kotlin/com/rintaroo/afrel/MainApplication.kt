package com.rintaroo.afrel

import android.app.Application
import com.rintaroo.afrel.di.androidModule
import com.rintaroo.afrel.di.initKoin
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
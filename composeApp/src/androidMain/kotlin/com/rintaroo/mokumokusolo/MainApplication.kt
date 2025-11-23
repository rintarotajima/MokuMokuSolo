package com.rintaroo.mokumokusolo

import android.app.Application
import com.rintaroo.mokumokusolo.di.androidModule
import com.rintaroo.mokumokusolo.di.initKoin
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
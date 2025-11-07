package com.example.mokumokusolo.di

import com.example.mokumokusolo.data.database.AppDatabase
import com.example.mokumokusolo.data.database.getDatabaseBuilder
import com.example.mokumokusolo.data.database.getRoomDatabase
import com.example.mokumokusolo.util.IosUrlOpener
import com.example.mokumokusolo.util.UrlOpener
import org.koin.core.context.startKoin
import org.koin.dsl.module

val iosModule = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder()
        getRoomDatabase(builder)
    }
    single<UrlOpener> { IosUrlOpener() }
}

fun initKoinIos() {
    startKoin {
        modules(commonAppModule(), iosModule)
    }
}
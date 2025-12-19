package com.rintaroo.afrel.di

import com.rintaroo.afrel.data.database.AppDatabase
import com.rintaroo.afrel.data.database.getDatabaseBuilder
import com.rintaroo.afrel.data.database.getRoomDatabase
import com.rintaroo.afrel.util.IosUrlOpener
import com.rintaroo.afrel.util.UrlOpener
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
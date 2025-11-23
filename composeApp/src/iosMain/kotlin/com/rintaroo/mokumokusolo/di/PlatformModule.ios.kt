package com.rintaroo.mokumokusolo.di

import com.rintaroo.mokumokusolo.data.database.AppDatabase
import com.rintaroo.mokumokusolo.data.database.getDatabaseBuilder
import com.rintaroo.mokumokusolo.data.database.getRoomDatabase
import com.rintaroo.mokumokusolo.util.IosUrlOpener
import com.rintaroo.mokumokusolo.util.UrlOpener
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
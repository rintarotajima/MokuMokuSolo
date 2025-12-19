package com.rintaroo.afrel.di

import android.content.Context
import com.rintaroo.afrel.data.database.AppDatabase
import com.rintaroo.afrel.data.database.getDatabaseBuilder
import com.rintaroo.afrel.data.database.getRoomDatabase
import com.rintaroo.afrel.util.AndroidUrlOpener
import com.rintaroo.afrel.util.UrlOpener
import org.koin.dsl.module

val androidModule = module {
    single<AppDatabase> {
        val context = get<Context>()
        val builder = getDatabaseBuilder(context)
        getRoomDatabase(builder)
    }
    single<UrlOpener> { AndroidUrlOpener(get<Context>()) }
}
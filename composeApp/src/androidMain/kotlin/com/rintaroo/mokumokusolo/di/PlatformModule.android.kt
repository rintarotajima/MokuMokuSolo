package com.rintaroo.mokumokusolo.di

import android.content.Context
import com.rintaroo.mokumokusolo.data.database.AppDatabase
import com.rintaroo.mokumokusolo.data.database.getDatabaseBuilder
import com.rintaroo.mokumokusolo.data.database.getRoomDatabase
import com.rintaroo.mokumokusolo.util.AndroidUrlOpener
import com.rintaroo.mokumokusolo.util.UrlOpener
import org.koin.dsl.module

val androidModule = module {
    single<AppDatabase> {
        val context = get<Context>()
        val builder = getDatabaseBuilder(context)
        getRoomDatabase(builder)
    }
    single<UrlOpener> { AndroidUrlOpener(get<Context>()) }
}
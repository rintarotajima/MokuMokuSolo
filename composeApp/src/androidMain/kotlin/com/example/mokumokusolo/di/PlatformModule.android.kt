package com.example.mokumokusolo.di

import android.content.Context
import com.example.mokumokusolo.data.database.AppDatabase
import com.example.mokumokusolo.data.database.getDatabaseBuilder
import com.example.mokumokusolo.data.database.getRoomDatabase
import org.koin.dsl.module

val androidModule = module {
    single<AppDatabase> {
        val context = get<Context>()
        val builder = getDatabaseBuilder(context)
        getRoomDatabase(builder)
    }
}
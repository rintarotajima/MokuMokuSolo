package com.example.mokumokusolo.di

import com.example.mokumokusolo.data.database.AppDatabase
import com.example.mokumokusolo.data.database.getDatabaseBuilder
import com.example.mokumokusolo.data.database.getRoomDatabase
import org.koin.dsl.module

val iosModule = module {
    single<AppDatabase> {
        val builder = getDatabaseBuilder()
        getRoomDatabase(builder)
    }
}
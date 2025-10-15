package com.example.mokumokusolo.data.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.mokumokusolo.data.database.dao.AppDao
import com.example.mokumokusolo.data.database.dao.ExpenditureDao
import com.example.mokumokusolo.data.database.entity.App
import com.example.mokumokusolo.data.database.entity.Expenditure

@Database(entities = [App::class, Expenditure::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao
    abstract fun expenditureDao(): ExpenditureDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}
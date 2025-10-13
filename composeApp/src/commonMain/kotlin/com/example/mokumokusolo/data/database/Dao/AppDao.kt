package com.example.mokumokusolo.data.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.mokumokusolo.data.database.entity.App

@Dao
interface AppDao {
    @Insert
    suspend fun insert(app: App)

    @Update
    suspend fun update(app: App)

    @Delete
    suspend fun delete(app: App)
}
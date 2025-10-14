package com.example.mokumokusolo.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mokumokusolo.data.database.entity.App

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(app: App)

    @Update
    suspend fun update(app: App)

    @Delete
    suspend fun delete(app: App)

    @Query("SELECT * FROM apps")
    suspend fun getAllApps(): List<App>

    @Query("SELECT * FROM apps WHERE id = :id")
    suspend fun getAppById(id: Int): App?
}
package com.rintaroo.afrel.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.rintaroo.afrel.data.database.entity.App
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(app: App)

    @Update
    suspend fun update(app: App)

    @Delete
    suspend fun delete(app: App)

    @Query("DELETE FROM apps WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Query("SELECT * FROM apps")
    fun getAllApps(): Flow<List<App>>

    @Query("SELECT * FROM apps WHERE id = :id")
    fun getAppById(id: Int): Flow<App?>

    @Query("SELECT * FROM apps WHERE date >= :startOfMonth AND date < :startOfNextMonth")
    fun getAppsForMonth(startOfMonth: Long, startOfNextMonth: Long): Flow<List<App>>
}
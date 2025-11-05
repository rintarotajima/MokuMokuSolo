package com.example.mokumokusolo.data.repository

import com.example.mokumokusolo.data.database.entity.App
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun insertApp(app: App)
    suspend fun updateApp(app: App)
    suspend fun deleteApp(app: App)
    suspend fun deleteAppById(id: Int)
    fun getAllApps(): Flow<List<App>>
    fun getAppById(id: Int): Flow<App?>
    fun getAppsForMonth(startOfMonth: Long, startOfNextMonth: Long): Flow<List<App>>
}
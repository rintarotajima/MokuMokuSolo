package com.example.mokumokusolo.data.repository

import com.example.mokumokusolo.data.database.dao.AppDao
import com.example.mokumokusolo.data.database.entity.App
import kotlinx.coroutines.flow.Flow

class AppRepositoryImpl(private val appDao: AppDao) : AppRepository {
    override suspend fun insertApp(app: App) {
        appDao.insert(app)
    }

    override suspend fun updateApp(app: App) {
        appDao.update(app)
    }

    override suspend fun deleteApp(app: App) {
        appDao.delete(app)
    }

    override fun getAllApps(): Flow<List<App>> {
        return appDao.getAllApps()
    }

    override fun getAppById(id: Int): Flow<App?> {
        return appDao.getAppById(id)
    }
}
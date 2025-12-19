package com.rintaroo.afrel.data.repository

import com.rintaroo.afrel.data.database.dao.AppDao
import com.rintaroo.afrel.data.database.entity.App
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

    override suspend fun deleteAppById(id: Int) {
        appDao.deleteById(id)
    }

    override fun getAllApps(): Flow<List<App>> {
        return appDao.getAllApps()
    }

    override fun getAppById(id: Int): Flow<App?> {
        return appDao.getAppById(id)
    }

    override fun getAppsForMonth(startOfMonth: Long, startOfNextMonth: Long): Flow<List<App>> {
        return appDao.getAppsForMonth(startOfMonth, startOfNextMonth)
    }
}
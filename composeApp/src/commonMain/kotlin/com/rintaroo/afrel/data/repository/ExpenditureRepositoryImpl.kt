package com.rintaroo.afrel.data.repository

import com.rintaroo.afrel.data.database.dao.ExpenditureDao
import com.rintaroo.afrel.data.database.entity.Expenditure
import kotlinx.coroutines.flow.Flow

class ExpenditureRepositoryImpl(private val expenditureDao: ExpenditureDao) :
    ExpenditureRepository {
    override suspend fun insertExpenditure(expenditure: Expenditure) {
        expenditureDao.insert(expenditure)
    }

    override suspend fun updateExpenditure(expenditure: Expenditure) {
        expenditureDao.update(expenditure)
    }

    override suspend fun deleteExpenditure(expenditure: Expenditure) {
        expenditureDao.delete(expenditure)
    }

    override suspend fun deleteExpenditureById(id: Int) {
        expenditureDao.deleteById(id)
    }

    override fun getAllExpenditures(): Flow<List<Expenditure>> {
        return expenditureDao.getAllExpenditures()
    }

    override fun getExpenditureById(id: Int): Flow<Expenditure?> {
        return expenditureDao.getExpenditureById(id)
    }

    override fun getExpendituresForMonth(startOfMonth: Long, startOfNextMonth: Long): Flow<List<Expenditure>> {
        return expenditureDao.getExpendituresForMonth(startOfMonth, startOfNextMonth)
    }
}
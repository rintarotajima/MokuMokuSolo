package com.example.mokumokusolo.data.repository

import com.example.mokumokusolo.data.database.dao.ExpenditureDao
import com.example.mokumokusolo.data.database.entity.Expenditure
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

    override fun getAllExpenditures(): Flow<List<Expenditure>> {
        return expenditureDao.getAllExpenditures()
    }

    override fun getExpenditureById(id: Int): Flow<Expenditure?> {
        return expenditureDao.getExpenditureById(id)
    }
}
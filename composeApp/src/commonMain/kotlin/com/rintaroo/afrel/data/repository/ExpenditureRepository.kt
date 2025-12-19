package com.rintaroo.afrel.data.repository

import com.rintaroo.afrel.data.database.entity.Expenditure
import kotlinx.coroutines.flow.Flow

interface ExpenditureRepository {
    suspend fun insertExpenditure(expenditure: Expenditure)
    suspend fun updateExpenditure(expenditure: Expenditure)
    suspend fun deleteExpenditure(expenditure: Expenditure)
    suspend fun deleteExpenditureById(id: Int)
    fun getAllExpenditures(): Flow<List<Expenditure>>
    fun getExpenditureById(id: Int): Flow<Expenditure?>
    fun getExpendituresForMonth(startOfMonth: Long, startOfNextMonth: Long): Flow<List<Expenditure>>
}
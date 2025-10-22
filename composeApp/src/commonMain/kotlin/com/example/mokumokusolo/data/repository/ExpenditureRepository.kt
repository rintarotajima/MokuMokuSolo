package com.example.mokumokusolo.data.repository

import com.example.mokumokusolo.data.database.entity.Expenditure
import kotlinx.coroutines.flow.Flow

interface ExpenditureRepository {
    suspend fun insertExpenditure(expenditure: Expenditure)
    suspend fun updateExpenditure(expenditure: Expenditure)
    suspend fun deleteExpenditure(expenditure: Expenditure)
    fun getAllExpenditures(): Flow<List<Expenditure>>
    fun getExpenditureById(id: Int): Flow<Expenditure?>
}
package com.example.mokumokusolo.data.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.example.mokumokusolo.data.database.entity.Expenditure

@Dao
interface ExpenditureDao {
    @Insert
    suspend fun insert(expenditure: Expenditure)

    @Update
    suspend fun update(expenditure: Expenditure)

    @Delete
    suspend fun delete(expenditure: Expenditure)
}
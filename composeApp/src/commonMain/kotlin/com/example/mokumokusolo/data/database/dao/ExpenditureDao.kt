package com.example.mokumokusolo.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.mokumokusolo.data.database.entity.Expenditure
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenditureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(expenditure: Expenditure)

    @Update
    suspend fun update(expenditure: Expenditure)

    @Delete
    suspend fun delete(expenditure: Expenditure)

    @Query("SELECT * FROM expenditures")
    fun getAllExpenditures(): Flow<List<Expenditure>>

    @Query("SELECT * FROM expenditures WHERE id = :id")
    fun getExpenditureById(id: Int): Flow<Expenditure?>
}
package com.example.mokumokusolo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenditures")
data class Expenditure(
    @PrimaryKey val id: Int,
    val name: String,
    val amount: Double,
)

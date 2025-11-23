package com.rintaroo.mokumokusolo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expenditures")
data class Expenditure(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val amount: Long,
    val date: Long,
)

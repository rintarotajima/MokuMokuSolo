package com.example.mokumokusolo.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "apps")
data class App(
    @PrimaryKey(autoGenerate = true) val id: Int?,
    val name: String,
    val amount: Long,
    val date: Long,
)
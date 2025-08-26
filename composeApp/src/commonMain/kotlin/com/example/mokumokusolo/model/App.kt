package com.example.mokumokusolo.model

import androidx.compose.ui.graphics.painter.Painter

data class App(
    val id: Int,
    val name: String,
    val image: Painter,
    val revenue: Double,
)


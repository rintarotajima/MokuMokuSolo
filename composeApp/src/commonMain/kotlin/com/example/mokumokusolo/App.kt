package com.example.mokumokusolo

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.example.mokumokusolo.ui.screen.HomeScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        HomeScreen()
    }
}
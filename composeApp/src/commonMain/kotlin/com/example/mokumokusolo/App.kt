package com.example.mokumokusolo

import androidx.compose.runtime.Composable
import com.example.mokumokusolo.ui.main.MainScreen
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MokuMokuSoloTheme {
        MainScreen()
    }
}
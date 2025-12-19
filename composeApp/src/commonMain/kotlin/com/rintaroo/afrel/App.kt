package com.rintaroo.afrel

import androidx.compose.runtime.Composable
import com.rintaroo.afrel.ui.main.MainScreen
import com.rintaroo.afrel.ui.theme.AfrelTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    AfrelTheme {
        MainScreen()
    }
}
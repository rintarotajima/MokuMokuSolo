package com.rintaroo.mokumokusolo

import androidx.compose.runtime.Composable
import com.rintaroo.mokumokusolo.ui.main.MainScreen
import com.rintaroo.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MokuMokuSoloTheme {
        MainScreen()
    }
}
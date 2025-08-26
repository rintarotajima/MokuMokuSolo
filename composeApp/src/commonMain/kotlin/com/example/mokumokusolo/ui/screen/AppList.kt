package com.example.mokumokusolo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mokumokusolo.model.App
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import mokumokusolo.composeapp.generated.resources.Res
import mokumokusolo.composeapp.generated.resources.duolingo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun AppListItem(app: App, modifier: Modifier = Modifier) {
    Row() {
        Image(
            painter = painterResource(Res.drawable.duolingo),
            contentDescription = ""
            )
        Text(text = app.name)
        Text(text = "${app.revenue}")
    }
}

@Preview
@Composable
fun AppListItemPreview() {
    MokuMokuSoloTheme {
        AppListItem(
            app = App(
                id = 1,
                name = "Duolingo",
                image = painterResource(Res.drawable.duolingo),
                revenue = 1000.0
            )
        )
    }
}
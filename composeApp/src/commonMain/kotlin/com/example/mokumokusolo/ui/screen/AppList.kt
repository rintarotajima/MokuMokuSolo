package com.example.mokumokusolo.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mokumokusolo.model.App
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import mokumokusolo.composeapp.generated.resources.Res
import mokumokusolo.composeapp.generated.resources.duolingo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppList(appList: List<App>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier
    ) {
        items(appList) { app ->
            AppListItem(app)
        }
    }
}

@Preview
@Composable
private fun AppListPreview() {
    MokuMokuSoloTheme {
        val sampleApps = listOf(
            App(
                id = 1,
                name = "Duolingo",
                image = painterResource(Res.drawable.duolingo),
                revenue = 1000.0
            ),
            App(
                id = 2,
                name = "Duolingo2",
                image = painterResource(Res.drawable.duolingo),
                revenue = 1500.0
            ),
            App(
                id = 3,
                name = "Duolingo3",
                image = painterResource(Res.drawable.duolingo),
                revenue = 2000.0
            )
        )
        AppList(
            appList = sampleApps
        )
    }
}


@Composable
fun AppListItem(app: App, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(MaterialTheme.colorScheme.background),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        Image(
            painter = painterResource(Res.drawable.duolingo),
            contentDescription = "",
            modifier = Modifier
                .width(40.dp)
                .padding(horizontal = 2.dp, vertical = 4.dp)
        )
        Text(text = app.name)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "¥${app.revenue}")
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
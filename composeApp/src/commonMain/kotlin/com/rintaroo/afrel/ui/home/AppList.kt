package com.rintaroo.afrel.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rintaroo.afrel.data.database.entity.App
import com.rintaroo.afrel.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun AppList(
    appList: List<App>,
    onAppClick: (App) -> Unit = {},
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(appList) { app ->
            AppListItem(
                app = app,
                onClick = { onAppClick(app) }
            )
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
                amount = 1000,
                date = 0L
            ),
            App(
                id = 2,
                name = "Spotify",
                amount = 1500,
                date = 0L
            ),
            App(
                id = 3,
                name = "Netflix",
                amount = 2000,
                date = 0L
            )
        )
        AppList(
            appList = sampleApps
        )
    }
}


@Composable
fun AppListItem(
    app: App,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        onClick = onClick,
        modifier = modifier
            .width(300.dp)
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = app.name,
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "¥${app.amount.toInt()}",
                color = Color.Gray,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodySmall
            )
        }
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
                amount = 1000,
                date = 0L
            )
        )
    }
}
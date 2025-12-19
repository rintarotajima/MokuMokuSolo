package com.rintaroo.afrel.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeCards(
    modifier: Modifier = Modifier,
    apps: List<com.rintaroo.afrel.data.database.entity.App> = emptyList(),
    expenditures: List<com.rintaroo.afrel.data.database.entity.Expenditure> = emptyList()
) {
    val uiState = updateHomeCardsUiState(apps, expenditures)

    ElevatedCard(
        modifier = modifier
            .width(300.dp)
            .background(MaterialTheme.colorScheme.background),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ) {
            Text(
                text = "今月の収支",
                style = MaterialTheme.typography.labelMedium,
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "¥${uiState.balance}",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = if (uiState.targetExpenditure != null) {
                    "Next: ${uiState.targetExpenditure.name} (${uiState.targetExpenditure.amount.toInt()})"
                } else {
                    ""
                },
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.size(8.dp))
            Box(
                modifier = Modifier
                    .height(32.dp),
                contentAlignment = Alignment.Center
            ) {
                LinearProgressIndicator(
                    progress = { uiState.progressRatio },
                    modifier = Modifier
                        .height(32.dp)
                        .padding(vertical = 2.dp),
                    color = MaterialTheme.colorScheme.primary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    strokeCap = StrokeCap.Butt,
                    gapSize = 0.dp
                )
                Text(
                    text = if (uiState.targetExpenditure != null) {
                        "${uiState.totalIncome.toInt()} / ${uiState.targetExpenditure.amount.toInt()}"
                    } else {
                        "0 / 0"
                    },
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 4.dp),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Preview
@Composable
fun HomeCardsPreview() {
    MaterialTheme {
        HomeCards()
    }
}
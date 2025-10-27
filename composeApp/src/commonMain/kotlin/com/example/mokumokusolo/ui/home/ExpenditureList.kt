package com.example.mokumokusolo.ui.home

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
import com.example.mokumokusolo.data.database.entity.Expenditure
import com.example.mokumokusolo.ui.theme.MokuMokuSoloTheme
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ExpenditureList(
    expenditureList: List<Expenditure>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(expenditureList) { expenditure ->
            ExpenditureListItem(expenditure)
        }
    }
}

@Preview
@Composable
fun ExpenditureListPreview() {
    MokuMokuSoloTheme {
        val sampleExpenditures = listOf(
            com.example.mokumokusolo.data.database.entity.Expenditure(
                id = 1,
                name = "Netflix",
                amount = 780
            ),
            com.example.mokumokusolo.data.database.entity.Expenditure(
                id = 2,
                name = "Spotify",
                amount = 980
            ),
            com.example.mokumokusolo.data.database.entity.Expenditure(
                id = 3,
                name = "Amazon Prime",
                amount = 500
            )
        )
        ExpenditureList(
            expenditureList = sampleExpenditures
        )
    }
}

@Composable
fun ExpenditureListItem(
    expenditure: com.example.mokumokusolo.data.database.entity.Expenditure,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
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
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = expenditure.name,
                modifier = Modifier.weight(1f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "¥${expenditure.amount.toInt()}",
                color = Color.Gray,
                fontSize = 16.sp,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview
@Composable
private fun ExpenditureListItemPreview() {
    MokuMokuSoloTheme {
        ExpenditureListItem(
            expenditure = com.example.mokumokusolo.data.database.entity.Expenditure(
                id = 1,
                name = "Netflix",
                amount = 780
            )
        )
    }
}
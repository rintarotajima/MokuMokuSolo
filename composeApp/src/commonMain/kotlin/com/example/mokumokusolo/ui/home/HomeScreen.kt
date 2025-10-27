package com.example.mokumokusolo.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mokumokusolo.data.database.entity.Expenditure
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    apps: List<com.example.mokumokusolo.data.database.entity.App> = emptyList(),
    expenditures: List<com.example.mokumokusolo.data.database.entity.Expenditure> = emptyList(),
    modifier: Modifier = Modifier
) {
    var selectedChip by remember { mutableStateOf("all") }

    Column(
        modifier = modifier
            .padding(top = 16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeCards(
            apps = apps,
            expenditures = expenditures
        )
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            AllChip(
                selected = selectedChip == "all",
                onClicked = { selectedChip = "all" }
            )
            AppsChip(
                selected = selectedChip == "apps",
                onClicked = { selectedChip = "apps" }
            )
            ExpenditureChip(
                selected = selectedChip == "expenditure",
                onClicked = { selectedChip = "expenditure" }
            )
        }
        when (selectedChip) {
            "all" -> {
                AppList(
                    appList = apps,
                    modifier = Modifier.width(300.dp)
                )
                ExpenditureList(
                    expenditureList = expenditures,
                )
            }

            "apps" -> AppList(
                appList = apps,
            )

            "expenditure" -> ExpenditureList(
                expenditureList = expenditures,
            )
        }
    }
}


@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        apps = listOf(
            com.example.mokumokusolo.data.database.entity.App(
                id = 1,
                name = "Twitter",
                amount = 120,
            )
        ),
        expenditures = listOf(
            Expenditure(
                id = 1,
                name = "Netflix",
                amount = 1500,
            )
        )
    )
}


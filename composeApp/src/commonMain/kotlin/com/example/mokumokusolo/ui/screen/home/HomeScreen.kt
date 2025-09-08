package com.example.mokumokusolo.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mokumokusolo.model.App
import com.example.mokumokusolo.model.Expenditure
import com.example.mokumokusolo.ui.screen.addItem.AddItemScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var selectedChip by remember { mutableStateOf("all") }
    var showAddItemScreen by remember { mutableStateOf(false) }

    var apps by remember { mutableStateOf(emptyList<App>()) }
    var expenditures by remember { mutableStateOf(emptyList<Expenditure>()) }

    if (showAddItemScreen) {
        AddItemScreen(
            onClose = { showAddItemScreen = false }
        )
    } else {
        Scaffold(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            floatingActionButton = {
                FloatingActionButton(
                    onClick = { showAddItemScreen = true },
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                ) {
                    Icon(Icons.Default.Add, "")
                }
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HomeCards()
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
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


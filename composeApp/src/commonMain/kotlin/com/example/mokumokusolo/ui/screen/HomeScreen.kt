package com.example.mokumokusolo.ui.screen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mokumokusolo.model.App
import mokumokusolo.composeapp.generated.resources.Res
import mokumokusolo.composeapp.generated.resources.duolingo
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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
    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        floatingActionButton = {
            FloatingActionButton(
                onClick = {},
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
                AllChip()
                AppsChip()
                ExpenditureChip()
            }
            AppList(
                appList = sampleApps,
                modifier = Modifier.width(300.dp)
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}


package com.example.mokumokusolo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.mokumokusolo.data.database.entity.App
import com.example.mokumokusolo.data.database.entity.Expenditure
import com.example.mokumokusolo.navigation.AppDestination
import com.example.mokumokusolo.navigation.bottomNavItems
import com.example.mokumokusolo.ui.addItem.AddItemScreen
import com.example.mokumokusolo.ui.home.HomeScreen
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel()
) {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination

    val apps by viewModel.apps.collectAsState()
    val expenditures by viewModel.expenditures.collectAsState()

    var showAddItemScreen by remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    val selected = when (item.destination) {
                        AppDestination.Home -> currentDestination?.hierarchy?.any { it.hasRoute<AppDestination.Home>() } == true
                        AppDestination.Calendar -> currentDestination?.hierarchy?.any { it.hasRoute<AppDestination.Calendar>() } == true
                    }

                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            val destination = item.destination
                            val options = navOptions {
                                popUpTo<AppDestination.Home> {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                            when (destination) {
                                AppDestination.Home -> navController.navigate(
                                    AppDestination.Home,
                                    options
                                )

                                AppDestination.Calendar -> navController.navigate(
                                    AppDestination.Calendar,
                                    options
                                )
                            }
                        },
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                    )
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showAddItemScreen = true }
            ) {
                Icon(Icons.Default.Add, "")
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = AppDestination.Home
        ) {
            composable<AppDestination.Home> {
                HomeScreen(
                    apps = apps,
                    expenditures = expenditures,
                    modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)
                )
            }
            composable<AppDestination.Calendar> {
                // Placeholder for Calendar Screen
                Text("Calendar Screen")
            }
        }

        if (showAddItemScreen) {
            AddItemScreen(
                onClose = { showAddItemScreen = false },
                onAddItem = { isIncome, name, amount ->
                    if (isIncome) {
                        val newApp = App(
                            id = 0,
                            name = name,
                            amount = amount.toLong()
                        )
                        viewModel.addApp(newApp)
                    } else {
                        val newExpenditure = Expenditure(
                            id = 0,
                            name = name,
                            amount = amount.toLong()
                        )
                        viewModel.addExpenditure(newExpenditure)
                    }
                    showAddItemScreen = false
                }
            )
        }
    }
}
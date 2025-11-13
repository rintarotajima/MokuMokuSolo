package com.example.mokumokusolo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
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
import androidx.navigation.toRoute
import com.example.mokumokusolo.data.database.entity.App
import com.example.mokumokusolo.data.database.entity.Expenditure
import com.example.mokumokusolo.model.ItemType
import com.example.mokumokusolo.model.toItemType
import com.example.mokumokusolo.model.toNavigationString
import com.example.mokumokusolo.navigation.AppDestination
import com.example.mokumokusolo.navigation.bottomNavItems
import com.example.mokumokusolo.ui.addItem.AddItemScreen
import com.example.mokumokusolo.ui.editItem.EditItemScreen
import com.example.mokumokusolo.ui.editItem.EditItemViewModel
import com.example.mokumokusolo.ui.home.HomeScreen
import com.example.mokumokusolo.ui.settings.SettingsScreen
import com.example.mokumokusolo.util.DateUtils
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
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

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            // Only show top bar on Home and Calendar screens
            val shouldShowTopBar = currentDestination?.hierarchy?.any {
                it.hasRoute<AppDestination.Home>() || it.hasRoute<AppDestination.Calendar>()
            } == true

            if (shouldShowTopBar) {
                TopAppBar(
                    title = { },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate(AppDestination.Settings)
                        }) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = "設定"
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { item ->
                    val selected = when (item.destination) {
                        AppDestination.Home -> currentDestination?.hierarchy?.any { it.hasRoute<AppDestination.Home>() } == true
                        AppDestination.Calendar -> currentDestination?.hierarchy?.any { it.hasRoute<AppDestination.Calendar>() } == true
                        else -> false
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

                                else -> {}
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
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = AppDestination.Home,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable<AppDestination.Home> {
                HomeScreen(
                    apps = apps,
                    expenditures = expenditures,
                    onAppClick = { app ->
                        app.id?.let { id ->
                            navController.navigate(
                                AppDestination.EditItem(
                                    itemId = id,
                                    itemTypeString = ItemType.App.toNavigationString()
                                )
                            )
                        }
                    },
                    onExpenditureClick = { expenditure ->
                        expenditure.id?.let { id ->
                            navController.navigate(
                                AppDestination.EditItem(
                                    itemId = id,
                                    itemTypeString = ItemType.Expenditure.toNavigationString()
                                )
                            )
                        }
                    },
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            composable<AppDestination.Calendar> {
                // Placeholder for Calendar Screen
                Text("Calendar Screen")
            }
            composable<AppDestination.Settings> {
                SettingsScreen(
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
            composable<AppDestination.EditItem> { backStackEntry ->
                val editItemDestination = backStackEntry.toRoute<AppDestination.EditItem>()
                val itemType = editItemDestination.itemTypeString.toItemType()
                val editItemViewModel: EditItemViewModel = koinViewModel(
                    parameters = {
                        parametersOf(
                            editItemDestination.itemId,
                            itemType
                        )
                    }
                )
                EditItemScreen(
                    viewModel = editItemViewModel,
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

        if (showAddItemScreen) {
            AddItemScreen(
                onClose = { showAddItemScreen = false },
                onAddItem = { isIncome, name, amount ->
                    try {
                        if (isIncome) {
                            val newApp = App(
                                id = 0,
                                name = name,
                                amount = amount.toLong(),
                                date = DateUtils.getCurrentDateMillis()
                            )
                            viewModel.addApp(newApp)
                        } else {
                            val newExpenditure = Expenditure(
                                id = 0,
                                name = name,
                                amount = amount.toLong(),
                                date = DateUtils.getCurrentDateMillis()
                            )
                            viewModel.addExpenditure(newExpenditure)
                        }
                        showAddItemScreen = false
                    } catch (e: NumberFormatException) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "金額は数値で入力してください。",
                                duration = SnackbarDuration.Short
                            )
                        }
                    } catch (e: Exception) {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = "データの追加に失敗しました。",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }
                }
            )
        }
    }
}
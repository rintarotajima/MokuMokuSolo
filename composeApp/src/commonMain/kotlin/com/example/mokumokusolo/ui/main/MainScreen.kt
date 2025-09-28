package com.example.mokumokusolo.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.example.mokumokusolo.navigation.AppDestination
import com.example.mokumokusolo.navigation.bottomNavItems
import com.example.mokumokusolo.ui.screen.home.HomeScreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination


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
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = AppDestination.Home
        ) {
            composable<AppDestination.Home> {
                HomeScreen(
                )
            }
            composable<AppDestination.Calendar> {
//                CalendarScreen()
            }
        }
    }
}
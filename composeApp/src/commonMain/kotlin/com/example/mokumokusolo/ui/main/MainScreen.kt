package com.example.mokumokusolo.ui.main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mokumokusolo.navigation.AppDestination
import com.example.mokumokusolo.ui.screen.home.HomeScreen

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        bottomBar = { }
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
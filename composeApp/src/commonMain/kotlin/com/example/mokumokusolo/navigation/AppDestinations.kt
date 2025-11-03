package com.example.mokumokusolo.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

sealed interface AppDestination {
    @Serializable
    data object Home : AppDestination

    @Serializable
    data object Calendar : AppDestination

    @Serializable
    data class EditItem(val itemId: Int, val itemTypeString: String) : AppDestination
}

data class BottomNavItem(
    val destination: AppDestination,
    val label: String,
    val icon: ImageVector
)

val bottomNavItems: List<BottomNavItem> = listOf(
    BottomNavItem(
        destination = AppDestination.Home,
        label = "Home",
        icon = Icons.Default.Home
    ),
    BottomNavItem(
        destination = AppDestination.Calendar,
        label = "Calendar",
        icon = Icons.Default.CalendarMonth
    )
)
package com.example.pgfinder
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : BottomBarScreen(
        route = "com.example.pgfinder.ui.theme.home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Interact",
        icon = Icons.Default.AccountCircle
    )

    object Create : BottomBarScreen(
        route = "create",
        title = "My Creates",
        icon = Icons.Default.Edit
    )

    object Settings : BottomBarScreen(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )


}
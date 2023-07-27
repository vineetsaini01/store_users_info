package com.practical.duplextask.presentation.ui.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen(route = "HomeScreen")
    object AddUserScreen : Screen(route = "AddUserScreen")
}

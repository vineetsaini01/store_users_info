package com.practical.duplextask.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.practical.duplextask.presentation.ui.screens.AddUserScreen
import com.practical.duplextask.presentation.ui.screens.HomeScreen
import com.practical.duplextask.presentation.view_model.HomeViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val viewModel: HomeViewModel = hiltViewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(route = Screen.HomeScreen.route) {
            HomeScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(route = Screen.AddUserScreen.route) {
            AddUserScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}
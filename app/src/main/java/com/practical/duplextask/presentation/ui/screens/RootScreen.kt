package com.practical.duplextask.presentation.ui.screens

import androidx.compose.runtime.Composable
import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.practical.duplextask.presentation.ui.navigation.AppNavHost
import com.practical.duplextask.presentation.view_model.HomeViewModel

@SuppressLint("UnrememberedMutableState")
@Composable
fun RootScreen() {
    AppNavHost(navController = rememberNavController())
}

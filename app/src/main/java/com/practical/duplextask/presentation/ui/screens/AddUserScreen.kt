package com.practical.duplextask.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.practical.duplextask.presentation.view_model.HomeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddUserScreen(viewModel: HomeViewModel, navController: NavHostController) {
    Scaffold(Modifier.fillMaxSize()) {

        LaunchedEffect(viewModel.addUserScreenToHomeScreen) {
            if (viewModel.addUserScreenToHomeScreen) {
                viewModel.addUserScreenToHomeScreen = false
                navController.popBackStack()
            }
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp),
            Arrangement.spacedBy(16.dp)
        ) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "first name")},
                value = viewModel.firstName,
                onValueChange = viewModel::onChangeFirstName
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "last name")},
                value = viewModel.lastName,
                onValueChange = viewModel::onChangeLastName
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = viewModel.email,
                label = { Text(text = "email")},
                onValueChange = viewModel::onChangeEmail
            )

            TextField(
                modifier = Modifier.fillMaxWidth(),
                label = { Text(text = "mobile number")},
                value = viewModel.mobileNumber,
                onValueChange = viewModel::onChangeNumber
            )

            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = viewModel::onClickedSave
            ) {
                Text("Save")
            }
        }

    }
}



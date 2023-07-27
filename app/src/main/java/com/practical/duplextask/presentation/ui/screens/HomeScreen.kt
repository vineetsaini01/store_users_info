package com.practical.duplextask.presentation.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.practical.duplextask.presentation.ui.components.UserItem
import com.practical.duplextask.presentation.ui.navigation.Screen
import com.practical.duplextask.presentation.view_model.HomeViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavHostController) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddUserScreen.route)
                }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add User")
            }
        }
    ) {
        if (viewModel.userList != null) {
            Box {
                LazyColumn() {
                    items(viewModel.userList!!.size) { index ->
                        val user = viewModel.userList!![index]
                        UserItem(
                            user = user,
                            onOptionSelected = { user ->
                                viewModel.showDialog=true
                                viewModel.user=user
                            })
                    }
                }

                if (viewModel.showDialog) {
                    val user=viewModel.user
                    AlertDialog(
                        onDismissRequest = {
                            viewModel.showDialog= false
                        },
                        title = {
                            Text(text = user!!.firstName+" "+ user!!.lastName)
                        },
                        text = {
                            Column {
                                Text(text = "email: "+user!!.email)
                                Text(text = "mobile no: "+user.mobileNumber)
                            }
                        },
                        confirmButton = {
                            Button(
                                onClick = {
                                    viewModel.showDialog = false
                                },
                            ) {
                                Text(text = "Okay")
                            }
                        },
                    )
                }
            }

        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No Record Found")
            }

        }


    }

}



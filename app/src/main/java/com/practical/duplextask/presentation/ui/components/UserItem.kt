package com.practical.duplextask.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.practical.duplextask.domain.model.UserItemsData

@Composable
fun UserItem(
    user: UserItemsData,
    onOptionSelected: (UserItemsData) -> Unit
) {

    Card(
        Modifier
            .padding(horizontal = 16.dp, vertical = 5.dp)
            .clickable {
                onOptionSelected(user)
            }) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {

            Icon(imageVector = Icons.Default.Person, contentDescription = "Add User")

            Text(
                text = user.firstName + " " + user.lastName,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp)
            )
        }
    }

}

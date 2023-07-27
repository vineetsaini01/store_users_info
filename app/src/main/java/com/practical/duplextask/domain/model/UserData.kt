package com.practical.duplextask.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "UserItemsData")
data class UserItemsData(
    val firstName: String,
    val lastName: String,
    @PrimaryKey
    val email: String,
    val mobileNumber: String,
)

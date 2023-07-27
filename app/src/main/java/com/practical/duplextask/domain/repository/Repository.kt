package com.practical.duplextask.domain.repository

import com.practical.duplextask.domain.model.UserItemsData
import com.tootl.screensaver.utils.Resource
import kotlinx.coroutines.flow.Flow


interface Repository {
    suspend fun getUserData(): Flow<Resource<List<UserItemsData>>>
    suspend fun addUserData(data: UserItemsData)
}
package com.practical.duplextask.data.repository

import com.practical.duplextask.data.datasource.local.MyDao
import com.practical.duplextask.domain.model.UserItemsData
import com.practical.duplextask.domain.repository.Repository
import com.tootl.screensaver.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(private val myDao: MyDao) : Repository {

    override suspend fun getUserData(): Flow<Resource<List<UserItemsData>>> = flow {
        emit(Resource.Loading())
        val data = myDao.getFacilitiesData()
        emit(Resource.Success(data = data!!))
    }

    override suspend fun addUserData(data: UserItemsData) {
        myDao.insertFacilitiesData(data=data)
    }



}

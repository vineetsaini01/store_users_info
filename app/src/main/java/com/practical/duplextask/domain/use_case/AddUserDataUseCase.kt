package com.practical.duplextask.domain.use_case

import com.practical.duplextask.domain.model.UserItemsData
import com.practical.duplextask.domain.repository.Repository
import javax.inject.Inject

class AddUserDataUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke(data: UserItemsData) = repository.addUserData(data)

}
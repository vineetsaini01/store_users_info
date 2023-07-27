package com.practical.duplextask.domain.use_case

import com.practical.duplextask.domain.repository.Repository
import javax.inject.Inject

class GetUserDataUseCase @Inject constructor(private val repository: Repository) {

    suspend operator fun invoke() = repository.getUserData()

}
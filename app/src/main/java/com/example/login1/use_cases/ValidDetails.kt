package com.example.login1.use_cases

import com.example.login1.DataRepository
import javax.inject.Inject

class ValidDetails (
    private val dataRepository: DataRepository
) {

    suspend operator fun invoke(email: String, password: String): Boolean{
        return dataRepository.valid(email, password)
    }
}
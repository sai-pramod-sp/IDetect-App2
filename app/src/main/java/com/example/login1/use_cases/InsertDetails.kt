package com.example.login1.use_cases

import com.example.login1.DataRepository
import com.example.login1.data_source.Details
import javax.inject.Inject

class InsertDetails (
    private val dataRepository: DataRepository
) {

    suspend operator fun invoke(details: Details){
        dataRepository.insertDetails(details)
    }
}
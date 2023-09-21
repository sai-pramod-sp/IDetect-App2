package com.example.login1.Repository

import com.example.login1.DataRepository
import com.example.login1.data_source.DataDao
import com.example.login1.data_source.Details
import kotlinx.coroutines.flow.Flow

class DataRepositoryImpl(
    private val dataDao: DataDao
): DataRepository {

    override fun getDetails(): Flow<List<Details>> {
        return dataDao.getDetails()
    }

    override suspend fun getDetailsByEmail(email: String): Details? {
        return dataDao.getDetailsByEmail(email)
    }

    override suspend fun insertDetails(details: Details) {
        return dataDao.insertDetails(details)
    }

    override suspend fun valid(email: String, password: String): Boolean {
        return dataDao.valid(email, password)
    }

}
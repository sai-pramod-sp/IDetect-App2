package com.example.login1

import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.login1.data_source.Details
import kotlinx.coroutines.flow.Flow

interface DataRepository {

    fun getDetails() : Flow<List<Details>>

    suspend fun getDetailsByEmail(email: String): Details?

    suspend fun insertDetails(details: Details)

    suspend fun valid(email: String, password: String): Boolean
}
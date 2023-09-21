package com.example.login1.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {

    @Query("SELECT * FROM Details")
    fun getDetails() : Flow<List<Details>>

    @Query("SELECT * FROM Details WHERE email = :email")
    suspend fun getDetailsByEmail(email: String): Details?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetails(details: Details)

    @Query("SELECT EXISTS (SELECT * FROM Details WHERE email =:email and password=:password)")
    suspend fun valid(email: String, password: String): Boolean

}
package com.example.login1.data_source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Details(

    val firstname: String,
    val lastName: String,
    val email: String,
    val password: String,
    @PrimaryKey(autoGenerate = true) val id: Int ?= null
)

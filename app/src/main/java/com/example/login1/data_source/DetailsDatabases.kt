package com.example.login1.data_source

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Details::class],
    version = 2
)
abstract class DetailsDatabases: RoomDatabase() {

    abstract val dataDao: DataDao

    companion object{
        const val DATABASE_NAME = "Details_db"
    }
}
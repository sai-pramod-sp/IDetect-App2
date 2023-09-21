package com.example.login1.di

import android.app.Application
import androidx.room.Room
import com.example.login1.DataRepository
import com.example.login1.Repository.DataRepositoryImpl
import com.example.login1.data_source.DetailsDatabases
import com.example.login1.use_cases.DataUseCases
import com.example.login1.use_cases.InsertDetails
import com.example.login1.use_cases.ValidDetails
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDetailsDatabase(app: Application): DetailsDatabases {
        return Room.databaseBuilder(
            app,
            DetailsDatabases::class.java,
            DetailsDatabases.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDetailsRepository(db: DetailsDatabases): DataRepository{
        return DataRepositoryImpl(db.dataDao)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: DataRepository): DataUseCases{
        return DataUseCases(
            insertDetails = InsertDetails(repository),
            validDetails = ValidDetails(repository)

        )
    }
}
package com.practical.duplextask.di

import android.app.Application
import androidx.room.Room
import com.practical.duplextask.data.datasource.local.MyDao
import com.practical.duplextask.data.datasource.local.MyDatabase
import com.practical.duplextask.data.repository.RepositoryImpl
import com.practical.duplextask.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {



    @Singleton
    @Provides
    fun providesMyDao(application: Application): MyDao {
        return Room.databaseBuilder(
            application,
            MyDatabase::class.java,
            "bharat.db"
        ).build().myDao
    }

    @Singleton
    @Provides
    fun providesRepository(myDao: MyDao): Repository {
        return RepositoryImpl(myDao = myDao)
    }


}
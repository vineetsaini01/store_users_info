package com.practical.duplextask.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.practical.duplextask.domain.model.UserItemsData

@Database(
    entities = [UserItemsData::class],
    version = 1,
    exportSchema = true
)
abstract class MyDatabase : RoomDatabase() {
    abstract val myDao: MyDao
}
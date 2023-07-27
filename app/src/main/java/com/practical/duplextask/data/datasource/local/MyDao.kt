package com.practical.duplextask.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.practical.duplextask.domain.model.UserItemsData

@Dao
interface MyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFacilitiesData(data: UserItemsData?)

    @Query("select * from UserItemsData")
    suspend fun getFacilitiesData(): List<UserItemsData>?

    @Query("delete from UserItemsData")
    suspend fun clearFacilitiesDataDto()


}
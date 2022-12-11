package com.manarelsebaay.madarsofttask.data.local
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo

@Dao
interface MadarDAO {

    @Insert(onConflict=OnConflictStrategy.REPLACE)
    suspend fun insertData(dataEntryInfo: DataEntryInfo)

    @Query("SELECT*FROM SavedData" )
    fun getSavedData():List<DataEntryInfo>

}
package com.manarelsebaay.madarsofttask.domain.repository

import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo

interface MadarRepository {

    //Room DB
    suspend fun insertData(item:DataEntryInfo)

    fun getSavedData(): List<DataEntryInfo>

}
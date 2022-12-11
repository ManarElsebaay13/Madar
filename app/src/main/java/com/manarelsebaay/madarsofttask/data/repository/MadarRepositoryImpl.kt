package com.manarelsebaay.madarsofttask.data.repository

import com.manarelsebaay.madarsofttask.data.local.MadarDatabase
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo
import com.manarelsebaay.madarsofttask.domain.repository.MadarRepository
import javax.inject.Inject

class MadarRepositoryImpl @Inject constructor(
    private val madarDatabase: MadarDatabase
):MadarRepository {

    override suspend fun insertData(item: DataEntryInfo) =madarDatabase.madarDAO.insertData(item)
    override fun getSavedData():List<DataEntryInfo> =madarDatabase.madarDAO.getSavedData()
}
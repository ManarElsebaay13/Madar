package com.manarelsebaay.madarsofttask.domain.use_case

import com.manarelsebaay.madarsofttask.core.utils.DispatcherProvider
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo
import com.manarelsebaay.madarsofttask.domain.repository.MadarRepository
import kotlinx.coroutines.withContext

import javax.inject.Inject


class SaveToDBUseCase @Inject constructor(
  private val madarRepository: MadarRepository,
  private val dispatcherProvider: DispatcherProvider
){
    @Throws(Throwable::class)
    suspend fun SaveToDB(info:DataEntryInfo) {
            withContext(dispatcherProvider.io()) {
                madarRepository.insertData(info)
            }
        }
    }

package com.manarelsebaay.madarsofttask.domain.use_case
import com.manarelsebaay.madarsofttask.core.utils.DispatcherProvider
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo
import com.manarelsebaay.madarsofttask.domain.repository.MadarRepository
import kotlinx.coroutines.withContext
import javax.inject.Inject


class GetDataUseCase @Inject constructor(
    private val madarRepository: MadarRepository,
    private val dispatcherProvider: DispatcherProvider
){
    @Throws(Throwable::class)
    suspend fun GetDatabase():List<DataEntryInfo>{
        return withContext(dispatcherProvider.io()){
            madarRepository.getSavedData()
        }
    }
}
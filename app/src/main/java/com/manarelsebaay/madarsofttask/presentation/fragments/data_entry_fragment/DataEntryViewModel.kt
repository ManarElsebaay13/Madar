package com.manarelsebaay.madarsofttask.presentation.fragments.data_entry_fragment

import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.madarsofttask.core.utils.Extensions.toString
import com.manarelsebaay.madarsofttask.core.utils.Extensions.toast
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo
import com.manarelsebaay.madarsofttask.domain.use_case.GetDataUseCase
import com.manarelsebaay.madarsofttask.domain.use_case.SaveToDBUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DataEntryViewModel @Inject constructor(
    private val saveToDBUseCase: SaveToDBUseCase,
    private val getDataUseCase: GetDataUseCase
):ViewModel(){

    fun Saving(dataEntryInfo: DataEntryInfo){
      viewModelScope.launch {
          try {
              SaveToDBUseCase(dataEntryInfo)
          } catch (e: IOException) {
          }
      }
    }
    suspend fun SaveToDBUseCase(dataEntryInfo: DataEntryInfo)=saveToDBUseCase.SaveToDB(dataEntryInfo)


}
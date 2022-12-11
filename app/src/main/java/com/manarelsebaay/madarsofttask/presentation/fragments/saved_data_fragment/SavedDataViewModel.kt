package com.manarelsebaay.madarsofttask.presentation.fragments.saved_data_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.manarelsebaay.madarsofttask.domain.model.DataEntryInfo
import com.manarelsebaay.madarsofttask.domain.use_case.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


@HiltViewModel
class SavedDataViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
): ViewModel() {
    fun SavedDataListState(): LiveData<List<DataEntryInfo>> = SavedDataListState
    private val SavedDataListState: MutableLiveData<List<DataEntryInfo>> = MutableLiveData()

    fun onLoading() {
        viewModelScope.launch {
            try {
                SavedDataListState.value = GetDataUseCase()!!
            } catch (e: IOException) {
            }
        }
    }

    suspend fun GetDataUseCase() = getDataUseCase.GetDatabase()
}
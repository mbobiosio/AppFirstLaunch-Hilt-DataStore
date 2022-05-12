package com.mbobiosio.firstlaunchutil.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mbobiosio.firstlaunchutil.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Mbuodile Obiosio
 * Twitter: @cazewonder
 */
@HiltViewModel
class AppViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    /**
     * Convert repository flow streams to LiveData using [asLiveData] extension function
     * */
    val isFirstLaunch: LiveData<Boolean> = dataStoreRepository.getFirstLaunch().asLiveData()

    /**
     * Set first launch with @param [isFirstLaunch]
     * */
    fun setFirstLaunch(isFirstLaunch: Boolean) =
        viewModelScope.launch {
            dataStoreRepository.saveFirstLaunch(isFirstLaunch)
        }
}

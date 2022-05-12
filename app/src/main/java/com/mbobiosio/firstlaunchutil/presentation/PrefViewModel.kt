package com.mbobiosio.firstlaunchutil.presentation

import androidx.lifecycle.ViewModel
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
class PrefViewModel @Inject constructor(
    private val firstLaunchRepository: DataStoreRepository
) : ViewModel() {

    /**
     * Set first launch with @param [isFirstLaunch]
     * */
    fun setFirstLaunch(isFirstLaunch: Boolean) =
        viewModelScope.launch {
            firstLaunchRepository.saveFirstLaunch(isFirstLaunch)
        }
}

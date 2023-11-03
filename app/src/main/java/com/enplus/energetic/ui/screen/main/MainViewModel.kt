package com.enplus.energetic.ui.screen.main

import androidx.lifecycle.ViewModel
import com.enplus.energetic.ui.util.NavDestinations
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


    //TODO add string pattern check
    fun getDataScreenKey(searchValue: String): String? {
        return when (searchValue) {
            "1" -> {
                NavDestinations.ADDRESS_DATA_SCREEN
            }

            "2" -> {
                NavDestinations.DATA_SCREEN
            }

            else -> null
        }
    }
}

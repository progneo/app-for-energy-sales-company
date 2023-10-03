package com.enplus.energetic.ui.screen.oneTimePin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OneTimePinViewModel @Inject constructor() : ViewModel() {

    var isUserAuthorized by mutableStateOf(true)
        private set

    private var _inputtedPin by mutableStateOf("")

    fun completePinInput(value: String) {
        _inputtedPin = value
    }
}

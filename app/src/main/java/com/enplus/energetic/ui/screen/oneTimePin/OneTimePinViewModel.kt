package com.enplus.energetic.ui.screen.oneTimePin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.data.preference.PinManager
import com.enplus.energetic.util.VibrationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OneTimePinViewModel @Inject constructor(
    private val pinManager: PinManager,
    val vibrationManager: VibrationManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<OneTimePinUiState>(OneTimePinUiState.InProcessing)
    val uiState: StateFlow<OneTimePinUiState>
        get() = _uiState.asStateFlow()

    private var _createdPin by mutableStateOf("")

    var inputtedPin by mutableStateOf("")
        private set

    init {
        checkIsPinSet()
    }

    private fun checkIsPinSet() {
        _uiState.tryEmit(OneTimePinUiState.InProcessing)

        viewModelScope.launch {
            if (pinManager.checkIsSet()) {
                _uiState.tryEmit(OneTimePinUiState.InputtingPin)
            } else {
                _uiState.tryEmit(OneTimePinUiState.CreatePin)
            }
        }
    }

    fun inputtingPin(value: String) {
        inputtedPin = value
    }

    fun createPin() {
        _createdPin = inputtedPin
        inputtedPin = ""

        _uiState.tryEmit(OneTimePinUiState.RepeatPin)
    }

    fun equalPin() {
        _uiState.tryEmit(OneTimePinUiState.InProcessing)

        viewModelScope.launch {
            if (pinManager.equal(inputtedPin)) {
                _uiState.tryEmit(OneTimePinUiState.Success(OneTimePinUiState.InputtingPin))

                delay(1000L)
                inputtedPin = ""

                _uiState.tryEmit(OneTimePinUiState.Completed)
            } else {
                _uiState.tryEmit(OneTimePinUiState.Error(OneTimePinUiState.InputtingPin))

                delay(1000L)
                inputtedPin = ""

                _uiState.tryEmit(OneTimePinUiState.InputtingPin)
            }
        }
    }

    fun savePin() {
        if (_createdPin == inputtedPin) {
            viewModelScope.launch {
                _uiState.tryEmit(OneTimePinUiState.Success(OneTimePinUiState.RepeatPin))

                delay(1000L)
                inputtedPin = ""

                _uiState.tryEmit(OneTimePinUiState.Completed)
            }

            CoroutineScope(Dispatchers.IO).launch {
                pinManager.save(_createdPin)
            }
        } else {
            viewModelScope.launch {
                _uiState.tryEmit(OneTimePinUiState.Error(OneTimePinUiState.RepeatPin))

                delay(1000L)
                inputtedPin = ""

                _uiState.tryEmit(OneTimePinUiState.CreatePin)
            }
        }
    }
}

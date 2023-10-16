package com.enplus.energetic.ui.screen.oneTimePin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.data.preference.PinManager
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
) : ViewModel() {

    private val _uiState = MutableStateFlow<OneTimePinUiState>(OneTimePinUiState.InProcessing)
    val uiState: StateFlow<OneTimePinUiState>
        get() = _uiState.asStateFlow()

    private var _createdPin by mutableStateOf("")

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

    fun createPin(createdPin: String) {
        _createdPin = createdPin

        _uiState.tryEmit(OneTimePinUiState.RepeatPin)
    }

    fun equalPin(inputtedPin: String) {
        _uiState.tryEmit(OneTimePinUiState.InProcessing)

        viewModelScope.launch {
            if (pinManager.equal(inputtedPin)) {
                _uiState.tryEmit(OneTimePinUiState.Completed)
            } else {
                _uiState.tryEmit(OneTimePinUiState.Error(OneTimePinUiState.InputtingPin))

                delay(1500L)

                _uiState.tryEmit(OneTimePinUiState.InputtingPin)
            }
        }
    }

    fun savePin(repeatedPin: String) {
        if (_createdPin == repeatedPin) {
            _uiState.tryEmit(OneTimePinUiState.Completed)

            CoroutineScope(Dispatchers.IO).launch {
                pinManager.save(_createdPin)
            }
        } else {
            viewModelScope.launch {
                _uiState.tryEmit(OneTimePinUiState.Error(OneTimePinUiState.RepeatPin))

                delay(1500L)

                _uiState.tryEmit(OneTimePinUiState.CreatePin)
            }
        }
    }
}

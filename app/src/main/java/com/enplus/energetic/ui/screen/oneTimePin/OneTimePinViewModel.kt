package com.enplus.energetic.ui.screen.oneTimePin

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.data.preference.PasswordManager
import com.enplus.energetic.data.preference.PhoneNumberManager
import com.enplus.energetic.data.preference.PinManager
import com.enplus.energetic.ui.util.VibrationManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OneTimePinViewModel @Inject constructor(
    private val pinManager: PinManager,
    private val authStateManager: AuthStateManager,
    private val passwordManager: PasswordManager,
    private val phoneNumberManager: PhoneNumberManager,
    val vibrationManager: VibrationManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<OneTimePinUiState>(OneTimePinUiState.InProcessing)
    val uiState: StateFlow<OneTimePinUiState>
        get() = _uiState.asStateFlow()

    private var _createdPin by mutableStateOf(EMPTY_PIN)

    var inputtedPin by mutableStateOf(EMPTY_PIN)
        private set

    init {
        checkIsPinSet()
    }

    fun inputtingPin(value: String) {
        inputtedPin = value
    }

    fun createPin() {
        _createdPin = inputtedPin
        inputtedPin = EMPTY_PIN

        _uiState.tryEmit(OneTimePinUiState.RepeatPin)
    }

    fun equalPin() {
        _uiState.tryEmit(OneTimePinUiState.InProcessing)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (pinManager.equal(inputtedPin)) {
                    _uiState.tryEmit(OneTimePinUiState.Success(OneTimePinUiState.InputtingPin))

                    delay(1000L)
                    inputtedPin = EMPTY_PIN

                    _uiState.tryEmit(OneTimePinUiState.Completed)
                } else {
                    _uiState.tryEmit(OneTimePinUiState.Error(OneTimePinUiState.InputtingPin))

                    delay(1000L)
                    inputtedPin = EMPTY_PIN

                    _uiState.tryEmit(OneTimePinUiState.InputtingPin)
                }
            }
        }
    }

    fun savePin() {
        viewModelScope.launch {
            if (_createdPin == inputtedPin) {

                _uiState.tryEmit(OneTimePinUiState.Success(OneTimePinUiState.RepeatPin))

                delay(1000L)
                inputtedPin = EMPTY_PIN

                _uiState.tryEmit(OneTimePinUiState.Completed)

                withContext(Dispatchers.IO) {
                    pinManager.save(_createdPin)
                }
            } else {

                _uiState.tryEmit(OneTimePinUiState.Error(OneTimePinUiState.RepeatPin))

                delay(1000L)
                inputtedPin = EMPTY_PIN

                _uiState.tryEmit(OneTimePinUiState.CreatePin)
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                authStateManager.remove()
                phoneNumberManager.remove()
                passwordManager.remove()
                pinManager.remove()
            }
        }
    }

    private fun checkIsPinSet() {
        _uiState.tryEmit(OneTimePinUiState.InProcessing)

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                if (pinManager.checkIsSet()) {
                    _uiState.tryEmit(OneTimePinUiState.InputtingPin)
                } else {
                    _uiState.tryEmit(OneTimePinUiState.CreatePin)
                }
            }
        }
    }

    companion object {
        private const val EMPTY_PIN = ""
    }
}

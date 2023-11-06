package com.enplus.energetic.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.data.preference.PasswordManager
import com.enplus.energetic.data.preference.PhoneNumberManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authStateManager: AuthStateManager,
    private val phoneNumberManager: PhoneNumberManager,
    private val passwordManager: PasswordManager,
) : ViewModel() {

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.SignedOut)
    val uiState = _uiState.asStateFlow()

    fun authorize(phoneNumber: String, password: String) {
        viewModelScope.launch {
            _uiState.tryEmit(LoginUiState.InProgress)

            delay(1500L) // emulate connecting to server

            /* TODO: request to server */
            if (phoneNumber == "9999999999" && password == "1234") {
                saveLoginData(phoneNumber, password)
                _uiState.tryEmit(LoginUiState.SignIn)
            } else {
                _uiState.tryEmit(LoginUiState.Error)
            }
        }
    }

    private fun saveLoginData(phoneNumber: String, password: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                authStateManager.save(true)
                phoneNumberManager.save(phoneNumber)
                passwordManager.save(password)
            }
        }
    }
}

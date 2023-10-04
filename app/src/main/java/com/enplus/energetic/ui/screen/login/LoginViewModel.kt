package com.enplus.energetic.ui.screen.login

import androidx.lifecycle.ViewModel
import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.data.preference.PasswordManager
import com.enplus.energetic.data.preference.PhoneNumberManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val _authStateManager: AuthStateManager,
    private val _phoneNumberManager: PhoneNumberManager,
    private val _passwordManager: PasswordManager,
) : ViewModel() {

    /* TODO: when use-case will be created */
    fun authorize() {
        _authStateManager.authState = true
    }
}

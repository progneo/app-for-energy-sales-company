package com.enplus.energetic.ui.screen.login

import androidx.lifecycle.ViewModel
import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.data.preference.PasswordManager
import com.enplus.energetic.data.preference.PhoneNumberManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authStateManager: AuthStateManager,
    private val phoneNumberManager: PhoneNumberManager,
    private val passwordManager: PasswordManager,
) : ViewModel() {

    /* TODO: when use-case will be created */
    fun authorize() {
        CoroutineScope(Dispatchers.IO).launch {
            authStateManager.save(true)
        }
    }
}

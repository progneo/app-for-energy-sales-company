package com.enplus.energetic.ui.screen.login

import androidx.lifecycle.ViewModel
import com.enplus.energetic.data.preference.AuthStateManagerImpl
import com.enplus.energetic.data.preference.PasswordManagerImpl
import com.enplus.energetic.data.preference.PhoneNumberManagerImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authStateManager: AuthStateManagerImpl,
    private val phoneNumberManager: PhoneNumberManagerImpl,
    private val passwordManager: PasswordManagerImpl,
) : ViewModel() {

    /* TODO: when use-case will be created */
    fun authorize() {
        CoroutineScope(Dispatchers.IO).launch {
            authStateManager.save(true)
        }
    }
}

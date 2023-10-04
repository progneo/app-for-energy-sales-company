package com.enplus.energetic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.data.preference.AuthStateManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authStateManager: AuthStateManager,
) : ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    private val _isAuthorized = MutableStateFlow(false)
    val isAuthorized = _isAuthorized.asStateFlow()

    init {
        viewModelScope.launch {
            val isAuthorized = async { authStateManager.get() }
            _isAuthorized.tryEmit(isAuthorized.await())
            delay(SPLASH_DELAY)
            _loading.value = false
        }
    }

    companion object {
        private const val SPLASH_DELAY = 1000L
    }
}

package com.enplus.energetic

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.data.preference.AuthStateManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authStateManager: AuthStateManager,
) : ViewModel() {

    private val _getAuthStateEvent: MutableSharedFlow<Boolean> =
        MutableSharedFlow(
            replay = 1,
            extraBufferCapacity = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST,
        )
    val getAuthStateEvent: Flow<Boolean> = _getAuthStateEvent.asSharedFlow()

    fun getAuthState() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val authState = authStateManager.get()
                _getAuthStateEvent.tryEmit(authState)
            }
        }
    }
}

package com.enplus.energetic.ui.screen.addressData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.domain.usecase.GetAddressDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddressDataViewModel @Inject constructor(
    private val getAddressDataUseCase: GetAddressDataUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<AddressDataState> = MutableStateFlow(AddressDataState.Loading)
    val state: StateFlow<AddressDataState> = _state.asStateFlow()

    init {
        //TODO pass address from input field
        loadData("")
    }

    private fun loadData(address: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val data = getAddressDataUseCase(address)
                _state.emit(AddressDataState.Content(data))
            }
        }
    }
}

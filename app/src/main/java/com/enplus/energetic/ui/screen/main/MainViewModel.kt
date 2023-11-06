package com.enplus.energetic.ui.screen.main

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.domain.usecase.GetAddressDataUseCase
import com.enplus.energetic.domain.usecase.GetPersonDataUseCase
import com.enplus.energetic.ui.mappers.AddressDataDomainToUiMapper
import com.enplus.energetic.ui.mappers.PersonDataDomainToUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPersonDataUseCase: GetPersonDataUseCase,
    private val getAddressDataUseCase: GetAddressDataUseCase,
    private val personDataDomainToUiMapper: PersonDataDomainToUiMapper,
    private val addressDataDomainToUiMapper: AddressDataDomainToUiMapper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Waiting)
    val uiState = _uiState.asStateFlow()

    fun getPersonData(searchValue: String) {
        viewModelScope.launch {
            _uiState.tryEmit(MainUiState.Loading)

            withContext(Dispatchers.IO) {
                when (checkInputType(searchValue)) {
                    InputType.AddressWithoutFlat -> {
                        getAddressDataUseCase(searchValue).let { addressData ->
                            if (addressData != null) {
                                val addressDataUiModel = addressDataDomainToUiMapper(addressData)
                                _uiState.tryEmit(
                                    MainUiState.SuccessGoToAddressData(
                                        addressDataUiModel
                                    )
                                )
                            } else {
                                _uiState.tryEmit(MainUiState.Error)
                            }
                        }
                    }

                    InputType.Other -> {
                        getPersonDataUseCase(searchValue).let { personData ->
                            if (personData != null) {
                                val personDataUiModel = personDataDomainToUiMapper(personData)
                                _uiState.tryEmit(MainUiState.SuccessGoToPersonData(personDataUiModel))
                            } else {
                                _uiState.tryEmit(MainUiState.Error)
                            }
                        }
                    }
                }
            }
        }
    }

    fun resetState() {
        _uiState.tryEmit(MainUiState.Waiting)
    }

    //TODO remove when add api integration
    private fun checkInputType(address: String): InputType {
        val addressParts = address.split(" ")
        return if (addressParts.size > 3 && hasFlatSubString(addressParts) || addressParts[0].isDigitsOnly()) {
            InputType.Other
        } else {
            InputType.AddressWithoutFlat
        }
    }

    private fun hasFlatSubString(addressParts: List<String>): Boolean {
        addressParts.forEach {
            if (it == "кв.") {
                return true
            }
        }

        return false
    }

    //TODO remove when add api integration
    private sealed class InputType {
        data object AddressWithoutFlat : InputType()

        data object Other : InputType()
    }
}

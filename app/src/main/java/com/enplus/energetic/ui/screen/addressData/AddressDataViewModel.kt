package com.enplus.energetic.ui.screen.addressData

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.domain.usecase.GetPersonDataUseCase
import com.enplus.energetic.ui.entities.AddressUiModel
import com.enplus.energetic.ui.mappers.PersonDataDomainToUiMapper
import com.google.gson.Gson
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
class AddressDataViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPersonDataUseCase: GetPersonDataUseCase,
    private val personDataDomainToUiMapper: PersonDataDomainToUiMapper,
) : ViewModel() {

    private val _addressDataString: String = checkNotNull(savedStateHandle["addressData"])
    private val _addressData =
        MutableStateFlow(Gson().fromJson(_addressDataString, AddressUiModel::class.java))
    val addressData = _addressData.asStateFlow()

    private val _state: MutableStateFlow<AddressDataState> = MutableStateFlow(AddressDataState.Loading)
    val state: StateFlow<AddressDataState> = _state.asStateFlow()

    init {
        loadData()
    }

    fun loadPersonData(data: String) {
        if (_state.value is AddressDataState.ProcessingCardClick) {
            return
        }

        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.tryEmit(AddressDataState.ProcessingCardClick(_addressData.value))

                getPersonDataUseCase(data).let { personData ->
                    if (personData != null) {
                        val mappedPersonData = personDataDomainToUiMapper(personData)
                        delay(300)
                        _state.tryEmit(AddressDataState.SuccessGoToPersonData(mappedPersonData))
                    } else {
                        _state.tryEmit(AddressDataState.Error(_addressData.value))
                    }
                }
            }
        }
    }

    fun resetState() {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.emit(AddressDataState.Content(_addressData.value))
            }
        }
    }
}

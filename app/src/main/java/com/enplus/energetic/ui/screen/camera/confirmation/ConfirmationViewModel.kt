package com.enplus.energetic.ui.screen.camera.confirmation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.domain.usecase.GetPersonDataUseCase
import com.enplus.energetic.ui.mappers.PersonDataDomainToUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ConfirmationViewModel @Inject constructor(
    val getPersonDataUseCase: GetPersonDataUseCase,
    private val mapper: PersonDataDomainToUiMapper,
) : ViewModel() {
    private val _uiState = MutableStateFlow<ConfirmationUiState>(ConfirmationUiState.Waiting)
    val uiState = _uiState.asStateFlow()

    fun getPersonData(searchValue: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _uiState.tryEmit(ConfirmationUiState.Loading)

                getPersonDataUseCase(searchValue).let { personData ->
                    if (personData != null) {
                        val personDataUiModel = mapper(personData)
                        _uiState.tryEmit(ConfirmationUiState.Success(personDataUiModel))
                    } else {
                        _uiState.tryEmit(ConfirmationUiState.Error)
                    }
                }
            }
        }
    }

    fun resetState() {
        _uiState.tryEmit(ConfirmationUiState.Waiting)
    }
}

package com.enplus.energetic.ui.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.domain.usecase.GetPersonDataUseCase
import com.enplus.energetic.ui.mappers.PersonDataDomainToUiMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val getPersonDataUseCase: GetPersonDataUseCase,
    private val mapper: PersonDataDomainToUiMapper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<MainUiState>(MainUiState.Waiting)
    val uiState = _uiState.asStateFlow()

    fun getPersonData(searchValue: String) {
        viewModelScope.launch {
            _uiState.tryEmit(MainUiState.Loading)

            getPersonDataUseCase(searchValue).let { personData ->
                if (personData != null) {
                    val personDataUiModel = mapper(personData)
                    _uiState.tryEmit(MainUiState.Success(personDataUiModel))
                } else {
                    _uiState.tryEmit(MainUiState.Error)
                }
            }
        }
    }

    fun resetState() {
        _uiState.tryEmit(MainUiState.Waiting)
    }
}

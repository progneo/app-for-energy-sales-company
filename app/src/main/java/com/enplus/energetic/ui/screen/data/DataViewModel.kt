package com.enplus.energetic.ui.screen.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enplus.energetic.domain.usecase.GetPersonDataUseCase
import com.enplus.energetic.ui.entities.MeterUiModel
import com.enplus.energetic.ui.mappers.PersonDataDomainToUiMapper
import com.enplus.energetic.ui.util.FlashlightManager
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
class DataViewModel @Inject constructor(
    val flashlightManager: FlashlightManager,
    private val getPersonDataUseCase: GetPersonDataUseCase,
    private val mapper: PersonDataDomainToUiMapper,
) : ViewModel() {

    private val _uiState = MutableStateFlow<DataUiState>(DataUiState.Loading)
    val uiState: StateFlow<DataUiState> = _uiState.asStateFlow()

    private val _isTorchActive = MutableStateFlow(false)
    val isTorchActive = _isTorchActive.asStateFlow()

    private val _metersLists = MutableStateFlow<List<MeterUiModel>>(listOf())

    private val _filteredMetersList = mutableStateListOf<MeterUiModel>().apply {
        addAll(_metersLists.value)
    }
    val filteredMetersList: SnapshotStateList<MeterUiModel>
        get() = _filteredMetersList


    //TODO add logic for adding filter items
    private val _filter = mutableStateMapOf<MeterUiModel.CategoryTypeUiModel, Boolean>().apply {
        set(MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY, true)
        set(MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY, true)
    }
    val filter: SnapshotStateMap<MeterUiModel.CategoryTypeUiModel, Boolean>
        get() = _filter

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                //mock server request delay
                delay(3000)
                val person = mapper(getPersonDataUseCase(""))
                val metersList = person.metersList ?: emptyList()
                _metersLists.tryEmit(metersList)
                _filteredMetersList.addAll(_metersLists.value)
                _uiState.tryEmit(DataUiState.Content)
            }
        }
    }

    fun changeTorchState() {
        val newTorchState = !_isTorchActive.value
        _isTorchActive.tryEmit(newTorchState)
    }

    fun applyFilter(categoryTypeUiModel: MeterUiModel.CategoryTypeUiModel, state: Boolean) {
        _filter[categoryTypeUiModel] = state
    }

    fun filterMetersList() {
        _filteredMetersList.clear()
        _filteredMetersList.addAll(_metersLists.value.filter { _filter[it.category] == true })
    }
}

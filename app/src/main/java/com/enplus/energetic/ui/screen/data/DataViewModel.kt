package com.enplus.energetic.ui.screen.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.enplus.energetic.ui.entities.MeterUiModel
import com.enplus.energetic.ui.entities.PersonDataUiModel
import com.enplus.energetic.ui.util.FlashlightManager
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val flashlightManager: FlashlightManager,
) : ViewModel() {
    private val _personDataString: String = checkNotNull(savedStateHandle["personData"])
    private val _personData =
        MutableStateFlow(Gson().fromJson(_personDataString, PersonDataUiModel::class.java))
    val personData = _personData.asStateFlow()

    private val _uiState = MutableStateFlow<DataUiState>(DataUiState.Content)
    val uiState: StateFlow<DataUiState> = _uiState.asStateFlow()

    private val _isTorchActive = MutableStateFlow(false)
    val isTorchActive = _isTorchActive.asStateFlow()

    private val _filteredMetersList = mutableStateListOf<MeterUiModel>().apply {
        _personData.value.metersList?.let { meterList ->
            addAll(meterList)
        }
    }
    val filteredMetersList: SnapshotStateList<MeterUiModel>
        get() = _filteredMetersList

    // TODO add logic for adding filter items
    private val _filter = mutableStateMapOf<MeterUiModel.CategoryTypeUiModel, Boolean>().apply {
        set(MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY, true)
        set(MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY, true)
    }
    val filter: SnapshotStateMap<MeterUiModel.CategoryTypeUiModel, Boolean>
        get() = _filter

    fun changeTorchState() {
        val newTorchState = !_isTorchActive.value
        _isTorchActive.tryEmit(newTorchState)
    }

    fun applyFilter(categoryTypeUiModel: MeterUiModel.CategoryTypeUiModel, state: Boolean) {
        _filter[categoryTypeUiModel] = state
    }

    fun filterMetersList() {
        _filteredMetersList.clear()
        _personData.value.metersList?.filter { _filter[it.category] == true }
            ?.let { _filteredMetersList.addAll(it) }
    }
}

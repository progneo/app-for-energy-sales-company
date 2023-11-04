package com.enplus.energetic.ui.screen.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.snapshots.SnapshotStateMap
import androidx.lifecycle.ViewModel
import com.enplus.energetic.domain.entities.Meter
import com.enplus.energetic.ui.entities.MeterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor() : ViewModel() {

    private val _isTorchActive = MutableStateFlow<Boolean>(false)
    val isTorchActive = _isTorchActive.asStateFlow()

    // TODO move mock to repo
    private val _metersLists = mutableStateListOf<MeterUiModel>().apply {
        addAll(
            listOf(
                MeterUiModel(
                    category = MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY,
                    type = "FBU 11205",
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Meter.Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Meter.Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Meter.Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
                MeterUiModel(
                    category = MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY,
                    type = "DBB 13201",
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Meter.Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Meter.Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Meter.Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
                MeterUiModel(
                    category = MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY,
                    type = "АГАТ 1-1",
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Meter.Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Meter.Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Meter.Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
            ),
        )
    }

    private val _filteredMetersList = mutableStateListOf<MeterUiModel>().apply {
        addAll(_metersLists)
    }
    val filteredMetersList: SnapshotStateList<MeterUiModel>
        get() = _filteredMetersList

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

    fun applyFilter(сategoryTypeUiModel: MeterUiModel.CategoryTypeUiModel, state: Boolean) {
        _filter[сategoryTypeUiModel] = state
    }

    fun filterMetersList() {
        _filteredMetersList.clear()
        _filteredMetersList.addAll(_metersLists.filter { _filter[it.category] == true })
    }
}

package com.enplus.energetic.ui.screen.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.enplus.energetic.domain.entities.Meter
import com.enplus.energetic.ui.entities.DataTypeUiModel
import com.enplus.energetic.ui.entities.MeterUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor() : ViewModel() {

    //TODO move mock to repo
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

    private val _metersTypeList = mutableStateListOf<MeterUiModel.CategoryTypeUiModel>().apply {
        addAll(listOf(MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY, MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY))
    }
    val metersTypeList: SnapshotStateList<MeterUiModel.CategoryTypeUiModel> get() = _metersTypeList

    var dataTypeUiModel by mutableStateOf(DataTypeUiModel.PERSONAL_ACCOUNT)
        private set

    fun filterMetersList(
        сategoryTypeUiModel: MeterUiModel.CategoryTypeUiModel,
        isSelected: Boolean,
    ) {
        if (isSelected) {
            _filteredMetersList.addAll(_metersLists.filter { it.category == сategoryTypeUiModel })
        } else {
            _filteredMetersList.removeIf { it.category == сategoryTypeUiModel }
        }
    }
}

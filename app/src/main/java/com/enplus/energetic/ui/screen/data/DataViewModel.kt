package com.enplus.energetic.ui.screen.data

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.enplus.energetic.data.model.DataType
import com.enplus.energetic.data.model.Meter
import com.enplus.energetic.data.model.MeterType
import com.enplus.energetic.data.model.Reading
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor() : ViewModel() {

    @RequiresApi(Build.VERSION_CODES.O)
    private val _metersList = mutableStateListOf<Meter>().apply {
        addAll(
            listOf(
                Meter(
                    type = MeterType.ELECTRICAL_ENERGY,
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
                Meter(
                    type = MeterType.HOT_WATER_SUPPLY,
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
                Meter(
                    type = MeterType.HOT_WATER_SUPPLY,
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
            )
        )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val _filteredMetersList = mutableStateListOf<Meter>().apply {
        addAll(_metersList)
    }
    val filteredMetersList: SnapshotStateList<Meter>
        @RequiresApi(Build.VERSION_CODES.O) get() = _filteredMetersList

    private val _metersTypeList = mutableStateListOf<MeterType>().apply {
        addAll(listOf(MeterType.ELECTRICAL_ENERGY, MeterType.HOT_WATER_SUPPLY))
    }
    val metersTypeList: SnapshotStateList<MeterType> get() = _metersTypeList

    var dataType by mutableStateOf(DataType.PERSONAL_ACCOUNT)
        private set

    @RequiresApi(Build.VERSION_CODES.O)
    fun filterMetersList(meterType: MeterType, isSelected: Boolean) {
        if (isSelected) {
            _filteredMetersList.addAll(_metersList.filter { it.type == meterType })
        } else {
            _filteredMetersList.removeIf { it.type == meterType }
        }
    }
}

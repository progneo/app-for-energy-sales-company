package com.enplus.energetic.ui.screen.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.lifecycle.ViewModel
import com.enplus.energetic.data.model.DataType
import com.enplus.energetic.data.model.MeterType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor() : ViewModel() {

    private val _metersList = mutableStateListOf<MeterType>().apply {
        addAll(MeterType.values())
    }
    val meterList: SnapshotStateList<MeterType> get() = _metersList

    var dataType by mutableStateOf(DataType.PERSONAL_ACCOUNT)
        private set

    var dataTypeDescription by mutableStateOf("234123414")
        private set
}
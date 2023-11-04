package com.enplus.energetic.ui.entities

import androidx.compose.ui.graphics.vector.ImageVector
import com.enplus.energetic.R
import com.enplus.energetic.ui.icon.ColdWater
import com.enplus.energetic.ui.icon.ElectricEnergy
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.HotWater
import com.enplus.energetic.ui.icon.ThermalEnergy

data class MeterUiModel(
    val category: CategoryTypeUiModel,
    val typeLabelId: Int,
    val typeValue: String,
    val stateLabelId: Int,
    val stateValue: Int,
    val factoryNumberLabelId: Int,
    val factoryNumberValue: String,
    val placingLabelId: Int,
    val placingValue: String,
    val checkDateLabelId: Int,
    val checkDateValue: String,
    val lastCheckDateLabelId: Int,
    val lastCheckDateValue: String,
    val sealLabelId: Int,
    val sealStateValue: Int,
    val lastReadingsLabelId: Int,
    val lastReadingsValue: List<ReadingUiModel>,
) {
    enum class CategoryTypeUiModel(
        val meterResId: Int,
        val typeResId: Int,
        val imageVector: ImageVector,
    ) {
        ELECTRICAL_ENERGY(
            meterResId = R.string.electrical_energy_meter,
            typeResId = R.string.electrical_energy,
            imageVector = EnIcons.ElectricEnergy,
        ),
        COLD_WATER_SUPPLY(
            meterResId = R.string.cold_water_meter,
            typeResId = R.string.cold_water,
            imageVector = EnIcons.ColdWater,
        ),
        HOT_WATER_SUPPLY(
            meterResId = R.string.hot_water_meter,
            typeResId = R.string.hot_water,
            imageVector = EnIcons.HotWater,
        ),
        THERMAL_ENERGY(
            meterResId = R.string.thermal_energy_meter,
            typeResId = R.string.thermal_energy,
            imageVector = EnIcons.ThermalEnergy,
        ),
    }

    data class ReadingUiModel(
        val value: String,
    )
}

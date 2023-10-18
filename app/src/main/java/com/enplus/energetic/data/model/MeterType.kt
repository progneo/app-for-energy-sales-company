package com.enplus.energetic.data.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.enplus.energetic.R
import com.enplus.energetic.ui.icon.ColdWater
import com.enplus.energetic.ui.icon.ElectricEnergy
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.HotWater
import com.enplus.energetic.ui.icon.ThermalEnergy

enum class MeterType(
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

package com.enplus.energetic.data.model

import com.enplus.energetic.R

enum class MeterType(val resId: Int) {
    ELECTRICAL_ENERGY(R.string.electrical_energy),
    COLD_WATER_SUPPLY(R.string.cold_water_supply),
    HOT_WATER_SUPPLY(R.string.hot_water_supply),
    THERMAL_ENERGY(R.string.thermal_energy),
}
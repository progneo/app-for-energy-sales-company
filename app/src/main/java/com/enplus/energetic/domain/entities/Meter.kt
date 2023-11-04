package com.enplus.energetic.domain.entities

import java.time.LocalDate

data class Meter(
    val category: CategoryType,
    val type: String,
    val state: Boolean,
    val factoryNumber: Long,
    val placing: String,
    val checkDate: LocalDate,
    val lastCheckDate: LocalDate,
    val sealState: Boolean,
    val lastReadings: List<Reading>,
) {

    enum class CategoryType {
        ELECTRICAL_ENERGY,

        COLD_WATER_SUPPLY,

        HOT_WATER_SUPPLY,

        THERMAL_ENERGY,
    }

    data class Reading(
        val date: LocalDate,
        val value: Long,
    )
}

package com.enplus.energetic.data.model

import java.time.LocalDate

data class Meter(
    val type: MeterType,
    val state: Boolean,
    val factoryNumber: Long,
    val address: String,
    val checkDate: LocalDate,
    val lastCheckDate: LocalDate,
    val sealState: Boolean,
    val lastReadings: List<Reading>,
)

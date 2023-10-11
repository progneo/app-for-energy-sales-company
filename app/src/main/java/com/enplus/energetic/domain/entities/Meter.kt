package com.enplus.energetic.domain.entities

import java.util.Date

data class Meter(
    val type: MeterType,
    val state: Boolean,
    val factoryNumber: Long,
    val address: String,
    val checkDate: Date,
    val lastCheckDate: Date,
    val sealState: Boolean,
    val lastReadings: List<Long>,
)

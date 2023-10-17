package com.enplus.energetic.data.model

import java.time.LocalDate

data class Reading(
    val date: LocalDate,
    val value: Long,
)

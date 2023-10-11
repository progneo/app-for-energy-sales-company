package com.enplus.energetic.domain.entities

data class PersonData(
    val personAccountId: Long?,
    val address: String?,
    val metersList: List<Meter>?,
)

package com.enplus.energetic.ui.entities

data class PersonDataUiModel(
    val personAccountId: Long?,
    val address: String?,
    val metersList: List<MeterUiModel>?,
)

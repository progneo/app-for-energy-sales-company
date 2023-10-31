package com.enplus.energetic.domain.entities

data class FlatData(
    val personId: Long,
    val flatNumber: Int,
    val metersCount: Int, //TODO возможно заменить на лист счетчиков
)

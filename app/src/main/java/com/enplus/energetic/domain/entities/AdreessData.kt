package com.enplus.energetic.domain.entities;

data class AddressData(
    val address: String,
    val flatDataList: List<FlatData>,
) {

    data class FlatData(
        val personId: Long,
        val flatNumber: Int,
        val metersCount: Int, //TODO возможно заменить на лист счетчиков
    )
}

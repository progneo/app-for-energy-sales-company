package com.enplus.energetic.data.api.entities

data class AddressDataResponse(
    val address: String,
    val flatDataList: List<FlatDataApi>,
)

data class FlatDataApi(
    val personId: Long,
    val flatNumber: Int,
    val metersCount: Int, //TODO change to PersonData
)

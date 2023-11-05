package com.enplus.energetic.data.api.entities

import java.time.LocalDate

// TODO remade when add retrofit
// @Serializable
data class PersonDataResponse(

    // @SerialName("id")
    val personAccountId: Long,
    // @SerialName("address")
    val address: String,
    // @SerialName("metersList")
    // @Contextual перед лист
    val metersList: List<MeterApi>?,
)

// @Serializable
data class MeterApi(

    // @SerialName("category")
    val category: CategoryTypeApi,
    // @SerialName("type")
    val type: String,
    // @SerialName("state")
    val state: Boolean,
    // @SerialName("factoryNumber")
    val factoryNumber: Long,
    // @SerialName("address")
    val placing: String,
    // @SerialName("checkDate")
    val checkDate: LocalDate,
    // @SerialName("lastCheckDate")
    val lastCheckDate: LocalDate,
    // @SerialName("sealState")
    val sealState: Boolean,
    // @SerialName("lastReadings")
    // @Contextual перед лист
    val lastReadings: List<ReadingApi>,
)

// @Serializable
data class ReadingApi(
    // @SerialName("date")
    val date: LocalDate,
    // @SerialName("value")
    val value: Long,
)

// @Serializable with CustomEnumSerializer
enum class CategoryTypeApi {
    ELECTRICAL_ENERGY,

    COLD_WATER_SUPPLY,

    HOT_WATER_SUPPLY,

    THERMAL_ENERGY,
}

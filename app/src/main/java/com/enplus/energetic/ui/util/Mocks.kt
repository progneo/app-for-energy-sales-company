package com.enplus.energetic.ui.util

import androidx.core.text.isDigitsOnly
import com.enplus.energetic.data.api.entities.AddressDataResponse
import com.enplus.energetic.data.api.entities.CategoryTypeApi
import com.enplus.energetic.data.api.entities.FlatDataApi
import com.enplus.energetic.data.api.entities.MeterApi
import com.enplus.energetic.data.api.entities.PersonDataResponse
import com.enplus.energetic.data.api.entities.ReadingApi
import java.time.LocalDate

object Mocks {

    fun getMockPersonDataResponse(data: String): PersonDataResponse? {
        val personDataList = listOf(
            PersonDataResponse(
                personAccountId = 123456789,
                address = "ул. Ломоносова д. 12 кв. 34",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.ELECTRICAL_ENERGY,
                        type = "CE308 C36.746. OGR1QYDUVFZ GBO1 SPDS",
                        state = false,
                        factoryNumber = 112280081,
                        placing = "В подсобном помещении",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = true,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 120100,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123999,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 128986,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
                        type = "DBB 13201",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "СанУзел",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.COLD_WATER_SUPPLY,
                        type = "АГАТ 1-1",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "СанУзел",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = true,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                ),
            ),
            PersonDataResponse(
                personAccountId = 123456790,
                address = "ул. Ломоносова д. 12 кв. 35",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.ELECTRICAL_ENERGY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
                        type = "АГАТ 1-2",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = true,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.COLD_WATER_SUPPLY,
                        type = "АГАТ 1-1",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = true,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.THERMAL_ENERGY,
                        type = "DBB 13201",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = true,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                ),
            ),
            PersonDataResponse(
                personAccountId = 123456791,
                address = "ул. Ломоносова д. 12 кв. 36",
                metersList = emptyList(),
            ),
            PersonDataResponse(
                personAccountId = 123456792,
                address = "ул. Ломоносова д. 12 кв. 37",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.THERMAL_ENERGY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
                        type = "АГАТ 1-2",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = true,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                ),
            ),
            PersonDataResponse(
                personAccountId = 123456793,
                address = "ул. Ломоносова д. 12 кв. 38",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.ELECTRICAL_ENERGY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                ),
            ),
            PersonDataResponse(
                personAccountId = 123456794,
                address = "ул. Ломоносова д. 12 кв. 39",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.COLD_WATER_SUPPLY,
                        type = "FBU 11205",
                        state = false,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.COLD_WATER_SUPPLY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.ELECTRICAL_ENERGY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                    MeterApi(
                        category = CategoryTypeApi.THERMAL_ENERGY,
                        type = "FBU 11205",
                        state = true,
                        factoryNumber = 112280081,
                        placing = "КРУ",
                        checkDate = LocalDate.of(2023, 9, 19),
                        lastCheckDate = LocalDate.of(2023, 9, 21),
                        sealState = false,
                        lastReadings = listOf(
                            ReadingApi(
                                date = LocalDate.of(2023, 9, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 10, 20),
                                value = 123123,
                            ),
                            ReadingApi(
                                date = LocalDate.of(2023, 11, 20),
                                value = 123123,
                            ),
                        ),
                    ),
                ),
            ),
            PersonDataResponse(
                personAccountId = 123456795,
                address = "ул. Ломоносова д. 12 кв. 40",
                metersList = emptyList(),
            ),
            PersonDataResponse(
                personAccountId = 123456796,
                address = "ул. Ломоносова д. 12 кв. 41",
                metersList = emptyList(),
            ),
            PersonDataResponse(
                personAccountId = 123456797,
                address = "ул. Ломоносова д. 12 кв. 42",
                metersList = emptyList(),
            ),
            PersonDataResponse(
                personAccountId = 123456798,
                address = "ул. Ломоносова д. 12 кв. 43",
                metersList = emptyList(),
            ),
        )

        return personDataList.firstOrNull { personData ->
            personData.address == data || (
                    data.isDigitsOnly() && (
                            personData.personAccountId == data.toLong() ||
                                    personData.metersList?.any { meter ->
                                        meter.factoryNumber == data.toLong()
                                    } ?: false
                            )
                    )
        }
    }

    fun getMockAddressDataResponse(data: String): AddressDataResponse? {

        val flats = mutableListOf<FlatDataApi>()

        for (i in 0..9) {
            flats.add(
                FlatDataApi(
                    personId = (123456789 + i).toLong(),
                    flatNumber = 34 + i,
                    metersCount = when (i) {
                        0 -> 3
                        1 -> 4
                        3 -> 2
                        4 -> 1
                        5 -> 6
                        else -> 0
                    },
                )
            )
        }

        val addressList: List<AddressDataResponse> = listOf(
            AddressDataResponse(
                address = "ул. Ломоносова д. 12",
                flatDataList = flats,
            )
        )

        return addressList.firstOrNull { addressData ->
            data == addressData.address
        }
    }
}

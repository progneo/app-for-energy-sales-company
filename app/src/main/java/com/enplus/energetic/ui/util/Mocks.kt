package com.enplus.energetic.ui.util

import androidx.core.text.isDigitsOnly
import com.enplus.energetic.data.api.entities.CategoryTypeApi
import com.enplus.energetic.data.api.entities.MeterApi
import com.enplus.energetic.data.api.entities.PersonDataResponse
import com.enplus.energetic.data.api.entities.ReadingApi
import java.time.LocalDate

object Mocks {

    fun getMockPersonDataResponse(data: String): PersonDataResponse? {
        val personDataList = listOf(
            PersonDataResponse(
                personAccountId = 123456,
                address = "Ломоносова 12",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.ELECTRICAL_ENERGY,
                        type = "FBU 11205",
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
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
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
                    MeterApi(
                        category = CategoryTypeApi.HOT_WATER_SUPPLY,
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
                ),
            ),
            PersonDataResponse(
                personAccountId = 123457,
                address = "Ломоносова 13",
                metersList = listOf(
                    MeterApi(
                        category = CategoryTypeApi.ELECTRICAL_ENERGY,
                        type = "FBU 11205",
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
                personAccountId = 123458,
                address = "Ломоносова 14",
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
}

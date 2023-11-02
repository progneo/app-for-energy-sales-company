package com.enplus.energetic.data.mappers

import com.enplus.energetic.data.api.entities.CategoryTypeApi
import com.enplus.energetic.data.api.entities.MeterApi
import com.enplus.energetic.data.api.entities.PersonDataResponse
import com.enplus.energetic.domain.entities.Meter
import com.enplus.energetic.domain.entities.PersonData

internal class PersonDataApiToDomainMapper : (PersonDataResponse) -> PersonData {
    override operator fun invoke(from: PersonDataResponse): PersonData {

        val metersList = from.metersList?.map { meterApi ->
            meterApi.toDomain()
        }

        return PersonData(
            personAccountId = from.personAccountId,
            address = from.address,
            metersList = metersList,
        )
    }

    private fun MeterApi.toDomain(): Meter {

        val category = when (this.category) {
            CategoryTypeApi.ELECTRICAL_ENERGY -> Meter.CategoryType.ELECTRICAL_ENERGY

            CategoryTypeApi.COLD_WATER_SUPPLY -> Meter.CategoryType.COLD_WATER_SUPPLY

            CategoryTypeApi.HOT_WATER_SUPPLY -> Meter.CategoryType.HOT_WATER_SUPPLY

            CategoryTypeApi.THERMAL_ENERGY -> Meter.CategoryType.THERMAL_ENERGY
        }

        return Meter(
            category = category,
            type = this.type,
            state = this.state,
            factoryNumber = this.factoryNumber,
            address = this.address,
            checkDate = this.checkDate,
            lastCheckDate = this.lastCheckDate,
            sealState = this.sealState,
            lastReadings = this.lastReadings.map { readingApi ->
                Meter.Reading(
                    date = readingApi.date,
                    value = readingApi.value,
                )
            },
        )
    }
}

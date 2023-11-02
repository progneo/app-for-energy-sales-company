package com.enplus.energetic.ui.mappers

import com.enplus.energetic.domain.entities.Meter
import com.enplus.energetic.domain.entities.PersonData
import com.enplus.energetic.ui.entities.MeterUiModel
import com.enplus.energetic.ui.entities.PersonDataUiModel

internal class PersonDataDomainToUiMapper : (PersonData) -> PersonDataUiModel {

    override operator fun invoke(from: PersonData): PersonDataUiModel {

        val metersList = from.metersList?.map { meter ->
            meter.toUiModel()
        }

        return PersonDataUiModel(
            personAccountId = from.personAccountId,
            address = from.address,
            metersList = metersList,
        )
    }

    private fun Meter.toUiModel(): MeterUiModel {

        val category = when (this.category) {
            Meter.CategoryType.ELECTRICAL_ENERGY -> MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY

            Meter.CategoryType.COLD_WATER_SUPPLY -> MeterUiModel.CategoryTypeUiModel.COLD_WATER_SUPPLY

            Meter.CategoryType.HOT_WATER_SUPPLY -> MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY

            Meter.CategoryType.THERMAL_ENERGY -> MeterUiModel.CategoryTypeUiModel.THERMAL_ENERGY
        }

        return MeterUiModel(
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

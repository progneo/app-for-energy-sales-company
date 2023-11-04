package com.enplus.energetic.ui.mappers

import com.enplus.energetic.domain.entities.PersonData
import com.enplus.energetic.ui.entities.PersonDataUiModel
import com.enplus.energetic.ui.factories.MeterUiModelFactory
import javax.inject.Inject

class PersonDataDomainToUiMapper @Inject constructor(
    private val meterUiModelFactory: MeterUiModelFactory,
) : (PersonData) -> PersonDataUiModel {

    override operator fun invoke(from: PersonData): PersonDataUiModel {

        val metersList = from.metersList?.map { meter ->
            meterUiModelFactory.create(meter)
        }

        return PersonDataUiModel(
            personAccountId = from.personAccountId,
            address = from.address,
            metersList = metersList,
        )
    }
}

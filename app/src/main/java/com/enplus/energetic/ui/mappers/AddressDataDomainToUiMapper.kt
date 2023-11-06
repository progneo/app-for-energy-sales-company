package com.enplus.energetic.ui.mappers

import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.ui.entities.AddressUiModel
import javax.inject.Inject

class AddressDataDomainToUiMapper @Inject constructor() : (AddressData) -> AddressUiModel {

    override fun invoke(from: AddressData): AddressUiModel {
        return AddressUiModel(
            address = from.address,
            flatDataList = from.flatDataList.map {
                AddressUiModel.FlatData(
                    personId = it.personId,
                    flatNumber = it.flatNumber,
                    metersCount = it.metersCount,
                )
            },
        )
    }
}

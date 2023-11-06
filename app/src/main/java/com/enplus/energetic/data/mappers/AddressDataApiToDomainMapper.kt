package com.enplus.energetic.data.mappers

import com.enplus.energetic.data.api.entities.AddressDataResponse
import com.enplus.energetic.domain.entities.AddressData
import javax.inject.Inject

class AddressDataApiToDomainMapper @Inject constructor() : (AddressDataResponse) -> AddressData {

    override fun invoke(from: AddressDataResponse): AddressData {

        return AddressData(
            address = from.address,
            flatDataList = from.flatDataList.map {
                AddressData.FlatData(
                    personId = it.personId,
                    flatNumber = it.flatNumber,
                    metersCount = it.metersCount,
                )
            }
        )
    }
}

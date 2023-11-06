package com.enplus.energetic.data.repository

import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.domain.repository.AddressDataRepository
import javax.inject.Inject

//TODO remove when add mock logic
class AddressDataRepositoryImpl @Inject constructor() : AddressDataRepository {

    override suspend fun getAddressData(address: String): AddressData {
        val flats = mutableListOf<AddressData.FlatData>()

        for (i in 0..30) {
            flats.add(
                AddressData.FlatData(
                    personId = (111209184 + i).toLong(),
                    flatNumber = 34 + i,
                    metersCount = 3,
                )
            )
        }

        return AddressData(
            address = "ул. Южное шоссе д. 2",
            flatDataList = flats
        )
    }
}

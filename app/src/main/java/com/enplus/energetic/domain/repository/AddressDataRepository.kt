package com.enplus.energetic.domain.repository

import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.domain.entities.FlatData
import javax.inject.Inject

interface AddressDataRepository {

    suspend fun getAddressData(address: String): AddressData
}

internal class AddressDataRepositoryImpl @Inject constructor() : AddressDataRepository {

    override suspend fun getAddressData(address: String): AddressData {
        val flats = mutableListOf<FlatData>()

        for (i in 0..30) {
            flats.add(
                FlatData(
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

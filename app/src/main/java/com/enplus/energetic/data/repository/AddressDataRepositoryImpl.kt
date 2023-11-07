package com.enplus.energetic.data.repository

import com.enplus.energetic.data.api.PersonDataService
import com.enplus.energetic.data.mappers.AddressDataApiToDomainMapper
import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.domain.repository.AddressDataRepository
import javax.inject.Inject

class AddressDataRepositoryImpl @Inject constructor(
    private val service: PersonDataService,
    private val apiToDomain: AddressDataApiToDomainMapper,
) : AddressDataRepository {

    override suspend fun getAddressData(address: String): AddressData? {
        val addressData = service.getAddressData(address)

        return if (addressData != null) {
            apiToDomain(addressData)
        } else {
            null
        }
    }
}

package com.enplus.energetic.domain.repository

import com.enplus.energetic.domain.entities.AddressData

interface AddressDataRepository {

    suspend fun getAddressData(address: String): AddressData?
}

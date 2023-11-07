package com.enplus.energetic.data.api

import com.enplus.energetic.data.api.entities.AddressDataResponse
import com.enplus.energetic.data.api.entities.PersonDataResponse
import com.enplus.energetic.ui.util.Mocks.getMockAddressDataResponse
import com.enplus.energetic.ui.util.Mocks.getMockPersonDataResponse
import javax.inject.Inject

interface PersonDataService {

    // retrofit GET()
    fun getPersonData(data: String): PersonDataResponse?

    fun getAddressData(address: String): AddressDataResponse?
}

// TODO remove when add retrofit
// mock retrofit
class PersonDataServiceImpl @Inject constructor() : PersonDataService {

    override fun getPersonData(data: String): PersonDataResponse? = getMockPersonDataResponse(data)
    override fun getAddressData(address: String): AddressDataResponse? = getMockAddressDataResponse(address)
}

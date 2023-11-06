package com.enplus.energetic.domain.usecase

import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.domain.repository.AddressDataRepository
import javax.inject.Inject

//TODO remove when add mock logic
interface GetAddressDataUseCase {

    suspend operator fun invoke(address: String): AddressData
}

//TODO remove when add mock logic
class GetAddressDataUseCaseImpl @Inject constructor(
    private val addressDataRepository: AddressDataRepository,
) : GetAddressDataUseCase {

    override suspend fun invoke(address: String): AddressData {
       return addressDataRepository.getAddressData(address)
    }
}

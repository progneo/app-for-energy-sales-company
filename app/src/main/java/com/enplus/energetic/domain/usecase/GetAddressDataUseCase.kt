package com.enplus.energetic.domain.usecase

import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.domain.repository.AddressDataRepository
import javax.inject.Inject

interface GetAddressDataUseCase {

    suspend operator fun invoke(address: String): AddressData
}

internal class GetAddressDataUseCaseImpl @Inject constructor(
    private val addressDataRepository: AddressDataRepository,
) : GetAddressDataUseCase {

    override suspend fun invoke(address: String): AddressData {
       return addressDataRepository.getAddressData(address)
    }
}

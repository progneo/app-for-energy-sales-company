package com.enplus.energetic.ui.screen.addressData

import com.enplus.energetic.domain.entities.AddressData

sealed class AddressDataState {

    data object Loading : AddressDataState()

    data class Content(
        val content: AddressData,
    ) : AddressDataState()
}

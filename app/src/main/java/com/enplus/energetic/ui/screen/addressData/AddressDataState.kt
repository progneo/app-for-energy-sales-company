package com.enplus.energetic.ui.screen.addressData

import com.enplus.energetic.ui.entities.AddressUiModel
import com.enplus.energetic.ui.entities.PersonDataUiModel

sealed class AddressDataState {

    data object Loading : AddressDataState()

    data class Content(
        val content: AddressUiModel,
    ) : AddressDataState()

    data class OnCardClicked(
        val data: PersonDataUiModel,
    ) : AddressDataState()

    data object Error : AddressDataState()
}

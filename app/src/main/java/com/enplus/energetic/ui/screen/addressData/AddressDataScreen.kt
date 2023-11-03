package com.enplus.energetic.ui.screen.addressData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.domain.entities.AddressData
import com.enplus.energetic.ui.components.base.TopBarWithReturn
import com.enplus.energetic.ui.components.data.AddressDataCard
import com.enplus.energetic.ui.components.data.DataScreenHeader
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Flat
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun AddressDataScreen(
    navController: NavController,
    viewModel: AddressDataViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()

    //TODO add loading state
    when (state) {
        is AddressDataState.Content -> AddressDataScreen(
            onBackClick = { navController.popBackStack() },
            addressData = (state as AddressDataState.Content).content,
        )

        else -> {}
    }
}

@Composable
fun AddressDataScreen(
    onBackClick: () -> Unit,
    addressData: AddressData,
) {

    Scaffold(
        topBar = { TopBarWithReturn(onBackClick) },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding(),
                    ),
                contentPadding = PaddingValues(
                    top = 16.dp,
                    start = 16.dp,
                    end = 16.dp,
                ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    DataScreenHeader(
                        modifier = Modifier.padding(bottom = 8.dp),
                        title = addressData.address,
                        subtitle = stringResource(
                            id = R.string.personal_accounts_counter,
                            addressData.flatDataList.size
                        ),
                        icon = EnIcons.Flat,
                    )
                }

                //TODO add onClick event
                items(addressData.flatDataList) { addressData ->
                    AddressDataCard(
                        flatNumber = addressData.flatNumber,
                        personNumber = addressData.personId,
                        metersCounter = addressData.metersCount,
                        onClick = {},
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(64.dp))
                }
            }
        },
    )
}

@Preview(showBackground = true, name = "Address data screen")
@Composable
fun AddressDataScreenPreview() {
    EnergeticTheme {
        AddressDataScreen(
            onBackClick = { },
            addressData = AddressData(
                address = "ул. Южное шоссе д. 2",
                flatDataList = listOf(
                    AddressData.FlatData(
                        personId = 111209184,
                        flatNumber = 53,
                        metersCount = 3,
                    ),
                ),
            ),
        )
    }
}

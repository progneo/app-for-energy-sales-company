package com.enplus.energetic.ui.screen.addressData

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.TopBarWithReturn
import com.enplus.energetic.ui.components.data.AddressDataCard
import com.enplus.energetic.ui.components.data.DataScreenHeader
import com.enplus.energetic.ui.entities.AddressUiModel
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Flat
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.util.NavDestinations

@Composable
fun AddressDataScreen(
    navController: NavController,
    viewModel: AddressDataViewModel = hiltViewModel(),
) {

    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    // TODO: add loading state
    LaunchedEffect(state) {
        when (state) {
            is AddressDataState.Error -> {
                Toast.makeText(context, "Тестовые данные еще не добавлены", Toast.LENGTH_SHORT)
                    .show()
                viewModel.resetState()
            }
            is AddressDataState.SuccessGoToPersonData -> {
                navController.navigate("${NavDestinations.DATA_SCREEN}/${(state as AddressDataState.SuccessGoToPersonData).data}")
                viewModel.resetState()
            }
            else -> Unit
        }
    }

    AddressDataScreen(
        onBackClick = { navController.popBackStack() },
        onCardClick = viewModel::loadPersonData,
        state = state,
    )
}

@Composable
fun AddressDataScreen(
    onBackClick: () -> Unit,
    onCardClick: (String) -> Unit,
    state: AddressDataState,
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
                val addressUiModel = when (state) {
                    is AddressDataState.Content -> state.content
                    is AddressDataState.ProcessingCardClick -> state.content
                    is AddressDataState.Error -> state.content
                    else -> null
                }

                addressUiModel?.let {
                    item {
                        DataScreenHeader(
                            modifier = Modifier.padding(bottom = 8.dp),
                            title = addressUiModel.address,
                            subtitle = stringResource(
                                id = R.string.personal_accounts_counter,
                                addressUiModel.flatDataList.size
                            ),
                            icon = EnIcons.Flat,
                        )
                    }

                    items(addressUiModel.flatDataList) { addressData ->
                        AddressDataCard(
                            onClick = {
                                onCardClick(addressData.personId.toString())
                            },
                            addressUiModel = AddressUiModel.FlatData(
                                flatNumber = addressData.flatNumber,
                                personId = addressData.personId,
                                metersCount = addressData.metersCount,
                            )
                        )
                    }
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
            onCardClick = { },
            state = AddressDataState.Content(
                content = AddressUiModel(
                    address = "ул. Южное шоссе д. 2",
                    flatDataList = listOf(
                        AddressUiModel.FlatData(
                            personId = 111209184,
                            flatNumber = 53,
                            metersCount = 3,
                        ),
                    ),
                ),
            ),
        )
    }
}

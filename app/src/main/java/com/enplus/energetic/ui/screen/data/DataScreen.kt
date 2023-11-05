package com.enplus.energetic.ui.screen.data

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.enplus.energetic.R
import com.enplus.energetic.ui.components.base.FilterChip
import com.enplus.energetic.ui.components.base.TopBarWithReturn
import com.enplus.energetic.ui.components.data.DataScreenHeader
import com.enplus.energetic.ui.components.data.MeterInformationCard
import com.enplus.energetic.ui.entities.MeterUiModel
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Flashlight
import com.enplus.energetic.ui.icon.House
import com.enplus.energetic.ui.icon.VisibilityOff
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun DataScreen(
    navController: NavController,
    viewModel: DataViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current

    val isTorchActive by viewModel.isTorchActive.collectAsStateWithLifecycle()

    val personData by viewModel.personData.collectAsState()
    val metersList = remember { viewModel.filteredMetersList }
    val filter = viewModel.filter

    LaunchedEffect(isTorchActive) {
        viewModel.flashlightManager.setFlashlightMode(context, isTorchActive)
    }

    // TODO add logic from receive data in useCase
    DataScreen(
        title = personData.address,
        subtitle = stringResource(R.string.data_screen_subtitle, personData.personAccountId),
        metersList = metersList,
        filter = filter,
        isTorchActive = isTorchActive,
        onTorchClick = viewModel::changeTorchState,
        onChipClick = { meterType, isSelected ->
            viewModel.applyFilter(meterType, isSelected)
            viewModel.filterMetersList()
        },
        onBackClick = navController::popBackStack,
        uiState = uiState,
    )
}

@Composable
fun DataScreen(
    title: String,
    subtitle: String,
    metersList: List<MeterUiModel>,
    filter: Map<MeterUiModel.CategoryTypeUiModel, Boolean>,
    isTorchActive: Boolean,
    onTorchClick: () -> Unit,
    onChipClick: (MeterUiModel.CategoryTypeUiModel, Boolean) -> Unit,
    onBackClick: () -> Unit,
    uiState: DataUiState,
) {
    Scaffold(
        topBar = {
            TopBarWithReturn(
                onBackClick = onBackClick,
                action = {
                    Box(
                        modifier = Modifier
                            .padding(end = 12.dp)
                            .shadow(elevation = 4.dp, shape = RoundedCornerShape(100))
                            .background(
                                color = if (isTorchActive) EnColor.Orange else EnColor.OrangeContainer,
                                shape = RoundedCornerShape(100),
                            )
                            .clip(RoundedCornerShape(100))
                            .clickable { onTorchClick() }
                            .padding(12.dp),
                    ) {
                        Icon(
                            imageVector = EnIcons.Flashlight,
                            contentDescription = "Фонарик",
                            tint = if (isTorchActive) EnColor.TextOnDark else EnColor.Orange,
                        )
                    }
                },
            )
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding(),
                    ),
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    item {
                        DataScreenHeader(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            title = title,
                            subtitle = subtitle,
                            icon = EnIcons.House,
                        )
                    }

                    item {
                        FilterMeterType(
                            filter = filter,
                            onFilterChange = { meterType, isSelected ->
                                onChipClick(meterType, isSelected)
                            },
                        )
                    }

                    if (uiState is DataUiState.Content) {
                        items(metersList) { meter ->
                            var expanded by rememberSaveable { mutableStateOf(false) }

                            MeterInformationCard(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                meterUiModel = meter,
                                isExpanded = expanded,
                                onExpandRequest = { expanded = !expanded },
                            )
                        }

                        if (metersList.any()) {
                            item {
                                Spacer(modifier = Modifier.height(64.dp))
                            }
                        }
                    } else if (uiState == DataUiState.Loading) {
                        item {
                            // TODO add placeholder
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth(),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ) {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(50.dp),
                                    color = EnColor.Orange,
                                    strokeWidth = 5.dp,
                                )
                            }
                        }
                    }
                }

                if (uiState is DataUiState.Content) {
                    if (metersList.isEmpty()) {
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .wrapContentHeight(Alignment.CenterVertically),
                        ) {
                            ContentNotFound()
                        }
                    }
                }
            }
        },
    )
}

@Composable
private fun FilterMeterType(
    filter: Map<MeterUiModel.CategoryTypeUiModel, Boolean>,
    onFilterChange: (MeterUiModel.CategoryTypeUiModel, Boolean) -> Unit,
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(filter.keys.toList()) {
            FilterChip(
                label = stringResource(id = it.typeResId),
                imageVector = it.imageVector,
                selected = filter.getOrDefault(it, false),
                onClick = { onFilterChange(it, !filter.getOrDefault(it, false)) },
            )
        }
    }
}

@Composable
private fun ContentNotFound(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 34.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = EnIcons.VisibilityOff,
            contentDescription = stringResource(id = R.string.not_found),
            tint = EnColor.Orange,
        )

        Text(
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.data_screen_meters_list_not_found),
            style = TextStyle(
                fontSize = 15.sp,
                color = EnColor.LightBlack,
            ),
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "Data screen")
@Composable
fun DataScreenPreview() {
    EnergeticTheme {
        DataScreen(
            title = "ул. Южное шоссе д. 2, кв 53",
            subtitle = "Лицевой счет 111209184",
            metersList = listOf(
                MeterUiModel(
                    category = MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY,
                    typeLabelId = R.string.meter_type_label,
                    typeValue = "SKAT 101M",
                    stateLabelId = R.string.meter_service_status_label,
                    stateValue = R.string.meter_service_status_turned_on,
                    factoryNumberLabelId = R.string.meter_factory_number_label,
                    factoryNumberValue = "1321312",
                    placingLabelId = R.string.meter_installation_location_label,
                    placingValue = "Ломоносова",
                    checkDateLabelId = R.string.meter_check_date_label,
                    checkDateValue = "12.12.2000",
                    lastCheckDateLabelId = R.string.meter_next_check_date_label,
                    lastCheckDateValue = "12.12.2000",
                    sealLabelId = R.string.meter_seal_label,
                    sealStateValue = R.string.meter_seal_exist_status,
                    lastReadingsLabelId = R.string.meter_last_readings_label,
                    lastReadingsValue = listOf(
                        MeterUiModel.ReadingUiModel(
                            value = "123123",
                        ),
                        MeterUiModel.ReadingUiModel(
                            value = "123123",
                        ),
                        MeterUiModel.ReadingUiModel(
                            value = "123123",
                        ),
                    ),
                ),
                MeterUiModel(
                    category = MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY,
                    typeLabelId = R.string.meter_type_label,
                    typeValue = "SKAT 101M",
                    stateLabelId = R.string.meter_service_status_label,
                    stateValue = R.string.meter_service_status_turned_on,
                    factoryNumberLabelId = R.string.meter_factory_number_label,
                    factoryNumberValue = "1321312",
                    placingLabelId = R.string.meter_installation_location_label,
                    placingValue = "Ломоносова",
                    checkDateLabelId = R.string.meter_check_date_label,
                    checkDateValue = "12.12.2000",
                    lastCheckDateLabelId = R.string.meter_next_check_date_label,
                    lastCheckDateValue = "12.12.2000",
                    sealLabelId = R.string.meter_seal_label,
                    sealStateValue = R.string.meter_seal_exist_status,
                    lastReadingsLabelId = R.string.meter_last_readings_label,
                    lastReadingsValue = listOf(
                        MeterUiModel.ReadingUiModel(
                            value = "123123",
                        ),
                        MeterUiModel.ReadingUiModel(
                            value = "123123",
                        ),
                        MeterUiModel.ReadingUiModel(
                            value = "123123",
                        ),
                    ),
                ),
            ),
            filter = mapOf(
                MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY to true,
                MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY to true,
            ),
            isTorchActive = false,
            onTorchClick = { },
            onChipClick = { _, _ -> },
            onBackClick = { },
            uiState = DataUiState.Content,
        )
    }
}

@Preview(showBackground = true, name = "Data screen with not found")
@Composable
fun DataScreenNotFoundPreview() {
    EnergeticTheme {
        DataScreen(
            title = "ул. Южное шоссе д. 2, кв 53",
            subtitle = "Лицевой счет 111209184",
            metersList = emptyList(),
            filter = mapOf(
                MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY to false,
                MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY to false,
            ),
            isTorchActive = true,
            onTorchClick = { },
            onChipClick = { _, _ -> },
            onBackClick = { },
            uiState = DataUiState.Content,
        )
    }
}

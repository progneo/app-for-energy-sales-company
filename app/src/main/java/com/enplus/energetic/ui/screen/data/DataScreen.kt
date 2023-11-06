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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
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
import com.enplus.energetic.ui.icon.DataNotFoundIcon
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.Flashlight
import com.enplus.energetic.ui.icon.House
import com.enplus.energetic.ui.icon.VisibilityOff
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.util.previewParameterProvider.DataScreenPreviewParameter
import com.enplus.energetic.ui.util.previewParameterProvider.DataScreenPreviewParameterProvider

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

                    if (uiState is DataUiState.Content) {
                        item {
                            FilterMeterType(
                                filter = filter,
                                onFilterChange = { meterType, isSelected ->
                                    onChipClick(meterType, isSelected)
                                },
                            )
                        }

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
                            // TODO: add filter and card placeholder
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

                        item {
                            Spacer(modifier = Modifier.height(64.dp))
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
                            ContentBanner(
                                imageVector = EnIcons.VisibilityOff,
                                text = stringResource(id = R.string.data_screen_meters_list_by_filter_not_found),
                            )
                        }
                    }
                }
                if (uiState is DataUiState.ContentWithoutMeters) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .wrapContentHeight(Alignment.CenterVertically),
                    ) {
                        ContentBanner(
                            imageVector = EnIcons.DataNotFoundIcon,
                            text = stringResource(id = R.string.data_screen_meters_list_not_found),
                        )
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
private fun ContentBanner(
    modifier: Modifier = Modifier,
    imageVector: ImageVector,
    text: String,
) {
    Column(
        modifier = modifier
            .padding(horizontal = 34.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterVertically),
    ) {
        Icon(
            modifier = Modifier.size(24.dp),
            imageVector = imageVector,
            contentDescription = stringResource(id = R.string.logo),
            tint = EnColor.Orange,
        )

        Text(
            textAlign = TextAlign.Center,
            text = text,
            style = TextStyle(
                fontSize = 15.sp,
                color = EnColor.LightBlack,
            ),
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "Data screen")
@Composable
fun DataScreenPreview(
    @PreviewParameter(DataScreenPreviewParameterProvider::class) parameter: DataScreenPreviewParameter,
) {
    EnergeticTheme {
        DataScreen(
            title = "ул. Южное шоссе д. 2, кв 53",
            subtitle = "Лицевой счет 111209184",
            metersList = parameter.metersList,
            filter = parameter.filter,
            isTorchActive = false,
            onTorchClick = { },
            onChipClick = { _, _ -> },
            onBackClick = { },
            uiState = DataUiState.Content,
        )
    }
}

@Preview(showBackground = true, name = "Data screen meters list not found")
@Composable
fun DataScreenNotFoundPreview() {
    EnergeticTheme {
        DataScreen(
            title = "ул. Южное шоссе д. 2, кв 53",
            subtitle = "Лицевой счет 111209184",
            metersList = emptyList(),
            filter = emptyMap(),
            isTorchActive = true,
            onTorchClick = { },
            onChipClick = { _, _ -> },
            onBackClick = { },
            uiState = DataUiState.ContentWithoutMeters,
        )
    }
}

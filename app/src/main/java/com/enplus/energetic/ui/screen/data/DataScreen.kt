package com.enplus.energetic.ui.screen.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.enplus.energetic.data.model.Meter
import com.enplus.energetic.data.model.MeterType
import com.enplus.energetic.data.model.Reading
import com.enplus.energetic.ui.components.base.FilterChip
import com.enplus.energetic.ui.components.base.TopBarWithReturn
import com.enplus.energetic.ui.components.data.DataScreenHeader
import com.enplus.energetic.ui.components.data.MeterInformationCard
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.House
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import java.time.LocalDate

@Composable
fun DataScreen(
    navController: NavController,
    viewModel: DataViewModel = hiltViewModel(),
) {
    val metersList = viewModel.filteredMetersList
    val metersTypeList = viewModel.metersTypeList

    DataScreen(
        title = "ул. Южное шоссе д. 2, кв 53",
        subtitle = "Лицевой счет 111209184",
        metersList = metersList,
        metersTypeList = metersTypeList,
        onChipClick = { meterType, isSelected ->
            viewModel.filterMetersList(meterType, isSelected)
        },
        onBackClick = { navController.popBackStack() },
    )
}

@Composable
fun DataScreen(
    title: String,
    subtitle: String,
    metersList: List<Meter>,
    metersTypeList: List<MeterType>,
    onChipClick: (MeterType, Boolean) -> Unit,
    onBackClick: () -> Unit,
) {
    Scaffold(
        containerColor = EnColor.Background,
        topBar = { TopBarWithReturn(onBackClick) },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        top = it.calculateTopPadding(),
                        bottom = it.calculateBottomPadding(),
                    ),
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
                    ChipsRow(
                        metersTypeList = metersTypeList,
                        onFilteredListChange = { meterType, isSelected ->
                            onChipClick(meterType, isSelected)
                        },
                    )
                }

                items(metersList) { meter ->
                    var expanded by rememberSaveable { mutableStateOf(false) }

                    MeterInformationCard(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        meter = meter,
                        isExpanded = expanded,
                        onExpandRequest = { expanded = !expanded },
                    )
                }

                item {
                    Spacer(modifier = Modifier.height(64.dp))
                }
            }
        },
    )
}

@Composable
private fun ChipsRow(
    metersTypeList: List<MeterType>,
    onFilteredListChange: (MeterType, Boolean) -> Unit,
) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(metersTypeList) {
            var isSelected by remember { mutableStateOf(metersTypeList.contains(it)) }

            FilterChip(
                label = stringResource(id = it.typeResId),
                imageVector = it.imageVector,
                selected = isSelected,
                onClick = {
                    isSelected = !isSelected
                    onFilteredListChange(it, isSelected)
                },
            )
        }
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "Data screen")
@Composable
fun DataScreenPreview() {
    //TODO move data mock to repository
    EnergeticTheme {
        DataScreen(
            title = "ул. Южное шоссе д. 2, кв 53",
            subtitle = "Лицевой счет 111209184",
            metersList = listOf(
                Meter(
                    type = MeterType.ELECTRICAL_ENERGY,
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
                Meter(
                    type = MeterType.HOT_WATER_SUPPLY,
                    state = true,
                    factoryNumber = 112280081,
                    address = "КРУ",
                    checkDate = LocalDate.of(2023, 9, 19),
                    lastCheckDate = LocalDate.of(2023, 9, 21),
                    sealState = true,
                    lastReadings = listOf(
                        Reading(
                            date = LocalDate.of(2023, 9, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 10, 20),
                            value = 123123,
                        ),
                        Reading(
                            date = LocalDate.of(2023, 11, 20),
                            value = 123123,
                        ),
                    ),
                ),
            ),
            metersTypeList = listOf(MeterType.ELECTRICAL_ENERGY, MeterType.HOT_WATER_SUPPLY),
            onChipClick = { _, _ -> },
            onBackClick = { },
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, name = "Data screen with view model")
@Composable
fun DataScreenViewModelPreview() {
    EnergeticTheme {
        DataScreen(
            navController = rememberNavController(),
            viewModel = DataViewModel(),
        )
    }
}

package com.enplus.energetic.ui.screen.data

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.enplus.energetic.data.model.Meter
import com.enplus.energetic.data.model.MeterType
import com.enplus.energetic.data.model.Reading
import com.enplus.energetic.ui.components.base.FilterChip
import com.enplus.energetic.ui.components.meter.MeterInformation
import com.enplus.energetic.ui.icon.ArrowLeft
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

@OptIn(ExperimentalMaterial3Api::class)
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
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(
                        onClick = { onBackClick() },
                        content = {
                            Icon(
                                modifier = Modifier.size(24.dp),
                                imageVector = EnIcons.ArrowLeft,
                                contentDescription = "",
                                tint = EnColor.Orange,
                            )
                        },
                    )
                },
            )
        },
        content = {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(top = it.calculateTopPadding() + 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    Header(title, subtitle)
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

                    MeterInformation(
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
private fun Header(
    title: String,
    subtitle: String,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            modifier = Modifier
                .weight(0.8f, fill = false),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Text(
                text = title,
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                ),
            )

            Text(
                text = subtitle,
                style = TextStyle(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Normal,
                    color = EnColor.TextSubtitle,
                ),
            )
        }

        Box(
            modifier = Modifier
                .padding(start = 16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(EnColor.OrangeBackground),
        ) {
            Icon(
                modifier = Modifier.align(Alignment.Center),
                imageVector = EnIcons.House,
                contentDescription = "",
                tint = EnColor.Orange,
            )
        }
    }
}

@Composable
private fun ChipsRow(
    metersTypeList: List<MeterType>,
    onFilteredListChange: (MeterType, Boolean) -> Unit,
) {
    LazyRow(
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

package com.enplus.energetic.ui.components.data

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.enplus.energetic.R
import com.enplus.energetic.domain.entities.Meter
import com.enplus.energetic.ui.components.base.Card
import com.enplus.energetic.ui.entities.MeterUiModel
import com.enplus.energetic.ui.icon.ChevronDown
import com.enplus.energetic.ui.icon.ChevronUp
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun MeterInformationCard(
    modifier: Modifier = Modifier,
    meterUiModel: MeterUiModel,
    isExpanded: Boolean = false,
    onExpandRequest: () -> Unit,
) {
    Card(
        modifier = modifier,
        onClick = onExpandRequest,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize(),
        ) {
            HeaderDropDownItem(
                title = stringResource(id = meterUiModel.category.meterResId),
                isExpanded = isExpanded,
                onExpandRequest = { onExpandRequest() },
            )

            AnimatedVisibility(
                visible = isExpanded,
                enter = fadeIn(),
                exit = fadeOut(),
            ) {
                InformationContent(meterUiModel = meterUiModel)
            }
        }
    }
}

@Composable
private fun HeaderDropDownItem(
    title: String,
    isExpanded: Boolean,
    onExpandRequest: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Text(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(
                    start = 20.dp,
                    top = 21.5.dp,
                    bottom = if (isExpanded) 14.dp else 21.5.dp,
                ),
            text = title,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = EnColor.TextTitle,
            ),
        )

        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 8.dp)
                .size(48.dp)
                .clip(CircleShape)
                .clickable { onExpandRequest() },
        ) {
            ToggleButton(
                modifier = Modifier.align(Alignment.Center),
                isExpanded = isExpanded,
            )
        }
    }
}

@Composable
private fun ToggleButton(
    modifier: Modifier = Modifier,
    isExpanded: Boolean,
) {
    AnimatedContent(
        modifier = modifier,
        targetState = isExpanded,
        label = "toggle button",
    ) { expanded ->
        when (expanded) {
            true -> {
                Icon(
                    imageVector = EnIcons.ChevronUp,
                    contentDescription = null,
                    tint = EnColor.Orange,
                )
            }

            false -> {
                Icon(
                    imageVector = EnIcons.ChevronDown,
                    contentDescription = null,
                    tint = EnColor.Orange,
                )
            }
        }
    }
}

@Composable
private fun InformationContent(
    modifier: Modifier = Modifier,
    meterUiModel: MeterUiModel,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 20.dp,
                end = 20.dp,
                bottom = 20.5.dp,
            ),
        verticalArrangement = Arrangement.spacedBy(17.dp),
    ) {
        Characteristic(
            title = stringResource(id = R.string.service_status),
            value = stringResource(
                id = if (meterUiModel.state) {
                    R.string.turned_on
                } else {
                    R.string.turned_off
                },
            ),
        )

        Characteristic(
            title = stringResource(id = R.string.meter_factory_number),
            value = meterUiModel.factoryNumber.toString(),
        )

        Characteristic(
            title = stringResource(id = R.string.installation_location),
            value = meterUiModel.address,
        )

        Characteristic(
            title = stringResource(id = R.string.check_date),
            value = meterUiModel.checkDate.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy"),
            ),
        )

        Characteristic(
            title = stringResource(id = R.string.next_check_date),
            value = meterUiModel.lastCheckDate.format(
                DateTimeFormatter.ofPattern("dd MMMM yyyy"),
            ),
        )

        Characteristic(
            title = stringResource(id = R.string.seal),
            value = stringResource(
                id = if (meterUiModel.sealState) {
                    R.string.exist
                } else {
                    R.string.absent
                },
            ),
        )

        if (meterUiModel.lastReadings.any()) {
            Characteristic(
                title = stringResource(id = R.string.last_readings),
                values = meterUiModel.lastReadings.map {
                    "${it.date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))} - ${it.value}"
                },
            )
        } else {
            Characteristic(
                title = stringResource(id = R.string.meter_readings),
                value = stringResource(id = R.string.absents),
            )
        }
    }
}

@Composable
private fun Characteristic(
    title: String,
    value: String,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = EnColor.CharacteristicTitle,
            ),
        )

        Text(
            text = value,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = EnColor.TextTitle,
            ),
        )
    }
}

@Composable
private fun Characteristic(
    title: String,
    values: List<String>,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = EnColor.CharacteristicTitle,
            ),
        )

        for (value in values) {
            Text(
                text = value,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = EnColor.TextTitle,
                ),
            )
        }
    }
}

@Preview(name = "Information about meter")
@Composable
fun MeterInformationCardPreview() {
    var expanded by remember { mutableStateOf(false) }

    EnergeticTheme {
        MeterInformationCard(
            meterUiModel = MeterUiModel(
                category = MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY,
                type = "SKAT 101M",
                state = true,
                factoryNumber = 112280081,
                address = "КРУ",
                checkDate = LocalDate.of(2023, 9, 19),
                lastCheckDate = LocalDate.of(2023, 9, 21),
                sealState = true,
                lastReadings = emptyList(),
            ),
            isExpanded = expanded,
            onExpandRequest = { expanded = !expanded },
        )
    }
}

@Preview(name = "Expanded information about meter")
@Composable
fun ExpandedMeterInformationCardPreview() {
    var expanded by remember { mutableStateOf(true) }

    EnergeticTheme {
        MeterInformationCard(
            meterUiModel = MeterUiModel(
                category = MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY,
                type = "SKAT 101M",
                state = true,
                factoryNumber = 112280081,
                address = "КРУ",
                checkDate = LocalDate.of(2023, 9, 19),
                lastCheckDate = LocalDate.of(2023, 9, 21),
                sealState = true,
                lastReadings = listOf(
                    Meter.Reading(
                        date = LocalDate.of(2023, 9, 20),
                        value = 123123,
                    ),
                    Meter.Reading(
                        date = LocalDate.of(2023, 10, 20),
                        value = 123123,
                    ),
                    Meter.Reading(
                        date = LocalDate.of(2023, 11, 20),
                        value = 123123,
                    ),
                ),
            ),
            isExpanded = expanded,
            onExpandRequest = { expanded = !expanded },
        )
    }
}

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
import com.enplus.energetic.ui.components.base.Card
import com.enplus.energetic.ui.entities.MeterUiModel
import com.enplus.energetic.ui.icon.ChevronDown
import com.enplus.energetic.ui.icon.ChevronUp
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

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
            title = stringResource(id = meterUiModel.stateLabelId),
            value = stringResource(meterUiModel.stateValue),
        )

        Characteristic(
            title = stringResource(id = meterUiModel.typeLabelId),
            value = meterUiModel.typeValue,
        )

        Characteristic(
            title = stringResource(id = meterUiModel.factoryNumberLabelId),
            value = meterUiModel.factoryNumberValue,
        )

        Characteristic(
            title = stringResource(id = meterUiModel.placingLabelId),
            value = meterUiModel.placingValue,
        )

        Characteristic(
            title = stringResource(id = meterUiModel.checkDateLabelId),
            value = meterUiModel.checkDateValue,
        )

        Characteristic(
            title = stringResource(id = meterUiModel.lastCheckDateLabelId),
            value = meterUiModel.lastCheckDateValue,
        )

        Characteristic(
            title = stringResource(id = meterUiModel.sealLabelId),
            value = stringResource(id = meterUiModel.sealStateValue),
        )

        if (meterUiModel.lastReadingsValue.any()) {
            Characteristic(
                title = stringResource(id = meterUiModel.lastReadingsLabelId),
                values = meterUiModel.lastReadingsValue.map { reading -> reading.value },
            )
        } else {
            Characteristic(
                title = stringResource(id = meterUiModel.lastReadingsLabelId),
                value = stringResource(id = R.string.meter_last_readings_absents),
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
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = EnColor.CharacteristicTitle,
            ),
        )

        Text(
            text = value,
            style = TextStyle(
                fontSize = 20.sp,
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
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                color = EnColor.CharacteristicTitle,
            ),
        )

        values.forEach { value ->
            Text(
                text = value,
                style = TextStyle(
                    fontSize = 20.sp,
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
                typeLabelId = R.string.meter_type_label,
                typeValue = "SKAT 101M",
                stateLabelId = R.string.meter_service_status_label,
                stateValue =  R.string.meter_service_status_turned_on,
                factoryNumberLabelId = R.string.meter_factory_number_label,
                factoryNumberValue = "1321312",
                placingLabelId = R.string.meter_installation_location_label,
                placingValue = "Ломоносова",
                checkDateLabelId = R.string.meter_check_date_label,
                checkDateValue = "12.12.2000",
                lastCheckDateLabelId = R.string.meter_next_check_date_label,
                lastCheckDateValue = "12.12.2000",
                sealLabelId = R.string.meter_seal_label,
                sealStateValue =  R.string.meter_seal_exist_status,
                lastReadingsLabelId = R.string.meter_last_readings_label,
                lastReadingsValue = emptyList(),
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
                typeLabelId = R.string.meter_type_label,
                typeValue = "SKAT 101M",
                stateLabelId = R.string.meter_service_status_label,
                stateValue =  R.string.meter_service_status_turned_on,
                factoryNumberLabelId = R.string.meter_factory_number_label,
                factoryNumberValue = "1321312",
                placingLabelId = R.string.meter_installation_location_label,
                placingValue = "Ломоносова",
                checkDateLabelId = R.string.meter_check_date_label,
                checkDateValue = "12.12.2000",
                lastCheckDateLabelId = R.string.meter_next_check_date_label,
                lastCheckDateValue = "12.12.2000",
                sealLabelId = R.string.meter_seal_label,
                sealStateValue =  R.string.meter_seal_exist_status,
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
            isExpanded = expanded,
            onExpandRequest = { expanded = !expanded },
        )
    }
}

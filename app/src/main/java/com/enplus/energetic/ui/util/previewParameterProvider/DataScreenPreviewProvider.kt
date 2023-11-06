package com.enplus.energetic.ui.util.previewParameterProvider

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.enplus.energetic.R
import com.enplus.energetic.ui.entities.MeterUiModel

class DataScreenPreviewParameterProvider :
    PreviewParameterProvider<DataScreenPreviewParameter> {
    override val values = sequenceOf(
        DataScreenPreviewParameter(
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
                MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY to false,
            ),
        ),
        DataScreenPreviewParameter(
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
                    category = MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY,
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
                    category = MeterUiModel.CategoryTypeUiModel.COLD_WATER_SUPPLY,
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
                    category = MeterUiModel.CategoryTypeUiModel.THERMAL_ENERGY,
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
                MeterUiModel.CategoryTypeUiModel.COLD_WATER_SUPPLY to true,
                MeterUiModel.CategoryTypeUiModel.THERMAL_ENERGY to true,
            ),
        ),
        DataScreenPreviewParameter(
            metersList = emptyList(),
            filter = mapOf(
                MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY to false,
                MeterUiModel.CategoryTypeUiModel.COLD_WATER_SUPPLY to false,
            ),
        ),
    )
}

data class DataScreenPreviewParameter(
    val metersList: List<MeterUiModel>,
    val filter: Map<MeterUiModel.CategoryTypeUiModel, Boolean>,
)

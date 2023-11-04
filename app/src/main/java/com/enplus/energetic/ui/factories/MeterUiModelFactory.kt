package com.enplus.energetic.ui.factories

import com.enplus.energetic.R
import com.enplus.energetic.domain.entities.Meter
import com.enplus.energetic.ui.entities.MeterUiModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

interface MeterUiModelFactory {

    fun create(meter: Meter): MeterUiModel
}

class MeterUiModelFactoryImpl @Inject constructor() : MeterUiModelFactory {

    override fun create(meter: Meter): MeterUiModel = meter.toUiModel()

    private fun Meter.toUiModel(): MeterUiModel {

        val category = createCategory(this.category)
        val checkDateValue = this.checkDate.toStringDate()
        val lastCheckDateValue = this.lastCheckDate.toStringDate()
        val factoryNumberValue = this.factoryNumber.toString()
        val stateValue = createStateValue(this.state)
        val sealStateValue = createSealState(this.sealState)
        val createLastReadings = createLastReadings(this.lastReadings)

        return MeterUiModel(
            category = category,
            typeLabelId = R.string.meter_type_label,
            typeValue = this.type,
            stateLabelId = R.string.meter_service_status_label,
            stateValue = stateValue,
            factoryNumberLabelId = R.string.meter_factory_number_label,
            factoryNumberValue = factoryNumberValue,
            placingLabelId = R.string.meter_installation_location_label,
            placingValue = this.placing,
            checkDateLabelId = R.string.meter_check_date_label,
            checkDateValue = checkDateValue,
            lastCheckDateLabelId = R.string.meter_next_check_date_label,
            lastCheckDateValue = lastCheckDateValue,
            sealLabelId = R.string.meter_seal_label,
            sealStateValue = sealStateValue,
            lastReadingsLabelId = R.string.meter_last_readings_label,
            lastReadingsValue = createLastReadings,
        )
    }

    private fun createCategory(category: Meter.CategoryType): MeterUiModel.CategoryTypeUiModel {
        return when (category) {
            Meter.CategoryType.ELECTRICAL_ENERGY -> MeterUiModel.CategoryTypeUiModel.ELECTRICAL_ENERGY

            Meter.CategoryType.COLD_WATER_SUPPLY -> MeterUiModel.CategoryTypeUiModel.COLD_WATER_SUPPLY

            Meter.CategoryType.HOT_WATER_SUPPLY -> MeterUiModel.CategoryTypeUiModel.HOT_WATER_SUPPLY

            Meter.CategoryType.THERMAL_ENERGY -> MeterUiModel.CategoryTypeUiModel.THERMAL_ENERGY
        }
    }

    private fun createLastReadings(reading: List<Meter.Reading>): List<MeterUiModel.ReadingUiModel> {
        return reading.map { readingApi ->
            MeterUiModel.ReadingUiModel(
                value = readingApi.date.toDateWithValue(readingApi.value),
            )
        }
    }

    private fun createStateValue(state: Boolean): Int {
        return if (state) {
            R.string.meter_service_status_turned_on
        } else {
            R.string.meter_service_status_turned_off
        }
    }

    private fun createSealState(sealState: Boolean): Int {
        return if (sealState) {
            R.string.meter_seal_exist_status
        } else {
            R.string.meter_seal_absent_status
        }
    }

    private fun LocalDate.toStringDate(pattern: String = CHECK_DATE_PATTERN): String {
        return this.format(
            DateTimeFormatter.ofPattern(pattern),
        )
    }

    private fun LocalDate.toDateWithValue(
        value: Long,
        pattern: String = READINGS_DATE_PATTERN
    ): String {
        return "${this.format(DateTimeFormatter.ofPattern(pattern))} - $value"
    }

    private companion object {

        const val CHECK_DATE_PATTERN = "dd MMMM yyyy"
        const val READINGS_DATE_PATTERN = "dd.MM.yyyy"
    }
}

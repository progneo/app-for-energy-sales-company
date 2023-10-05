package com.enplus.energetic.ui.screen.data

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.enplus.energetic.R
import com.enplus.energetic.data.model.DataType
import com.enplus.energetic.data.model.MeterType
import com.enplus.energetic.ui.components.dropDownItem.DropDownItem
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun DataScreen(
    viewModel: DataViewModel = hiltViewModel()
) {
    val metersList = viewModel.meterList
    val dataType = viewModel.dataType
    val dataTypeDescription = viewModel.dataTypeDescription

    DataScreen(
        dataType = dataType,
        dataTypeDescription = dataTypeDescription,
        metersList = metersList,
    )
}

@Composable
fun DataScreen(
    dataType: DataType,
    dataTypeDescription: String,
    metersList: List<MeterType>,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        item {
            Column {
                Text(stringResource(id = R.string.data_on))
                Text("${stringResource(id = dataType.resId)} $dataTypeDescription")
            }
        }

        items(metersList) {
            var expanded by remember { mutableStateOf(false) }

            DropDownItem(
                title = { Text(text = stringResource(id = it.resId)) },
                isExpanded = expanded,
                onExpandRequest = { expanded = !expanded },
                content = {

                    repeat(6) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text(text = "text")
                            Text(text = "value")
                        }
                    }
                },
            )
        }
    }
}

@Preview(name = "Data screen", showBackground = true)
@Composable
fun DataScreenPreview() {
    EnergeticTheme {
        DataScreen(
            dataType = DataType.PERSONAL_ACCOUNT,
            dataTypeDescription = "234123414",
            metersList = MeterType.values().toList(),
        )
    }
}

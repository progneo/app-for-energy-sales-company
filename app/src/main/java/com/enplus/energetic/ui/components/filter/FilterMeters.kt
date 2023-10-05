package com.enplus.energetic.ui.components.filter

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.enplus.energetic.R
import com.enplus.energetic.data.model.MeterType
import com.enplus.energetic.ui.components.base.CheckboxWithText
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun FilterMeters(
    metersList: Array<MeterType>,
    isOpened: Boolean,
    onConfirmRequest: (List<MeterType>) -> Unit,
    onDismissRequest: () -> Unit,
) {
    val metersMap = mutableMapOf<MeterType, MutableState<Boolean>>()

    if (isOpened) {
        AlertDialog(
            title = { Text(text = stringResource(id = R.string.filter)) },
            onDismissRequest = { onDismissRequest() },
            confirmButton = {
                TextButton(
                    onClick = {
                        onConfirmRequest(metersMap.filter { it.value.value }.keys.toList())
                        onDismissRequest()
                    },
                    content = {
                        Text(text = stringResource(id = R.string.find))
                    },
                )
            },
            dismissButton = {
                TextButton(
                    onClick = { onDismissRequest() },
                    content = {
                        Text(text = stringResource(id = R.string.close))
                    },
                )
            },
            text = {
                Column {
                    for (meter in metersList) {
                        metersMap[meter] = remember { mutableStateOf(true) }

                        CheckboxWithText(
                            checked = metersMap[meter]?.value ?: false,
                            onCheckedChange = {
                                Log.i("meter ${meter.name}", "${metersMap[meter]} before")
                                metersMap[meter]?.value = it
                                Log.i("meter ${meter.name}", "${metersMap[meter]} after")
                            },
                            text = { Text(text = stringResource(id = meter.resId)) },
                        )
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FilterMetersPreview() {
    EnergeticTheme {
        FilterMeters(
            metersList = MeterType.values(),
            isOpened = true,
            onConfirmRequest = { },
            onDismissRequest = { },
        )
    }
}

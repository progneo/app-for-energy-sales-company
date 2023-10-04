package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun CheckboxWithText(
    modifier: Modifier = Modifier,
    checked: Boolean,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit,
    text: @Composable () -> Unit,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checked,
            enabled = enabled,
            onCheckedChange = { onCheckedChange(it) },
        )
        text()
    }
}

@Preview(showBackground = true)
@Composable
fun CheckboxWithTextPreview() {
    var isChecked by remember { mutableStateOf(false) }

    EnergeticTheme {
        CheckboxWithText(
            modifier = Modifier.fillMaxWidth(),
            checked = isChecked,
            onCheckedChange = { isChecked = it },
            text = { Text(text = "Something text") },
        )
    }
}
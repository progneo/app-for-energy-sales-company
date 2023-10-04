package com.enplus.energetic.ui.component.base

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    readOnly: Boolean = false,
    enabled: Boolean = true,
    placeholder: String = "",
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .border(1.dp, MaterialTheme.colorScheme.secondary, RoundedCornerShape(10.dp)),
    ) {
        BasicTextField(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            textStyle = MaterialTheme.typography.bodyMedium,
            value = value,
            enabled = enabled,
            onValueChange = {
                onValueChange(it)
            },
            readOnly = readOnly,
            singleLine = true,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.primary),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier = Modifier.defaultMinSize(minHeight = 25.dp),
                        contentAlignment = Alignment.CenterStart,
                    ) {
                        if (value.isEmpty()) {
                            Text(
                                modifier = Modifier.alpha(0.7f),
                                text = placeholder,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                        innerTextField()
                    }
                }
            },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextFieldEmpty() {
    MaterialTheme {
        TextField(
            value = "",
            modifier = Modifier.padding(10.dp),
            placeholder = "Type something",
            onValueChange = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextFieldNotEmpty() {
    MaterialTheme {
        TextField(
            value = "Text",
            modifier = Modifier.padding(10.dp),
            placeholder = "Type something",
            onValueChange = {},
        )
    }
}

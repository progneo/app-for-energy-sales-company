package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun TextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String = "",
    tailingIcon: (@Composable () -> Unit)? = null,
) {
    val enTextSelectionColors = TextSelectionColors(
        handleColor = EnColor.Orange,
        backgroundColor = EnColor.OrangeDisabled,
    )

    CompositionLocalProvider(LocalTextSelectionColors provides enTextSelectionColors) {
        BasicTextField(
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))
                .background(EnColor.LightGray)
                .height(56.dp)
                .padding(vertical = 18.dp, horizontal = 12.dp)
                .fillMaxWidth(),
            textStyle = TextStyle(
                platformStyle = PlatformTextStyle(
                    includeFontPadding = false,
                ),
                fontSize = 17.sp,
            ),
            value = value,
            enabled = enabled,
            onValueChange = {
                onValueChange(it)
            },
            readOnly = readOnly,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            singleLine = true,
            visualTransformation = visualTransformation,
            cursorBrush = SolidColor(EnColor.Orange),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Box(
                        modifier = Modifier.defaultMinSize(minHeight = 20.dp),
                        contentAlignment = Alignment.CenterStart,

                    ) {
                        if (value.isEmpty()) {
                            Text(
                                modifier = Modifier.height(20.dp),
                                text = placeholder,
                                fontSize = 17.sp,
                                style = TextStyle(
                                    platformStyle = PlatformTextStyle(
                                        includeFontPadding = false,
                                    ),
                                ),
                                overflow = TextOverflow.Ellipsis,
                                color = EnColor.LightBlack,
                            )
                        }
                        innerTextField()
                    }
                    tailingIcon?.invoke()
                }
            },
        )
    }
}

@Preview(name = "Empty Text Field", showBackground = true)
@Composable
fun PreviewTextFieldEmpty() {
    MaterialTheme {
        TextField(
            value = "",
            modifier = Modifier.padding(10.dp),
            placeholder = "Введите текст",
            onValueChange = {},
        )
    }
}

@Preview(name = "Not Empty Text Field", showBackground = true)
@Composable
fun PreviewTextFieldNotEmpty() {
    MaterialTheme {
        TextField(
            value = "Текст",
            modifier = Modifier.padding(10.dp),
            placeholder = "Введите текст",
            onValueChange = {},
        )
    }
}

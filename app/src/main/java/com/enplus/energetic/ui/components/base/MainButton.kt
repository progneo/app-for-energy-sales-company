package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = EnColor.Orange,
        contentColor = Color.White,
        disabledContainerColor = EnColor.OrangeDisabled,
        disabledContentColor = Color.White,
    ),
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp),
        onClick = { onClick() },
        shape = RoundedCornerShape(16.dp),
        enabled = isEnabled,
        colors = colors,
    ) {
        Text(
            text = text,
            fontSize = 17.sp,
        )
    }
}

@Preview(name = "Enabled button with text")
@Composable
fun ButtonPreview() {
    MainButton(
        text = "Войти",
        onClick = {},
    )
}

@Preview(name = "Disabled button with text")
@Composable
fun DisabledButtonPreview() {
    MainButton(
        text = "Войти",
        onClick = {},
        isEnabled = false,
    )
}

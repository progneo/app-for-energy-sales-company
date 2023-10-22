package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.House
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
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
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(
                space = 6.dp,
                alignment = Alignment.CenterHorizontally,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            icon?.let {
                Icon(
                    modifier = Modifier.requiredSize(24.dp),
                    imageVector = it,
                    contentDescription = null,
                )
            }
            Text(
                text = text,
                fontSize = 17.sp,
                fontWeight = FontWeight(600),
                style = TextStyle(
                    platformStyle = PlatformTextStyle(
                        includeFontPadding = false,
                    ),
                ),
            )
        }
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

@Preview(name = "Button with icon")
@Composable
fun ButtonWithIconPreview() {
    MainButton(
        text = "Войти",
        icon = EnIcons.House,
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

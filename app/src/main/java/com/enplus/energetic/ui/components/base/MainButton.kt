package com.enplus.energetic.ui.components.base

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.icon.House
import com.enplus.energetic.ui.icon.Loader
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun MainButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
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
        onClick = {
            if (!isLoading) {
                onClick()
            }
        },
        shape = RoundedCornerShape(16.dp),
        enabled = isEnabled,
        colors = colors,
    ) {
        Box(contentAlignment = Alignment.Center) {
            if (isLoading) {
                LoadingIndicator()
            } else {
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
    }
}

@Composable
private fun LoadingIndicator() {
    val infiniteTransition = rememberInfiniteTransition(label = "Button loading indicator")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing),
        ),
        label = "Button loading indicator",
    )
    Icon(
        modifier = Modifier.graphicsLayer {
            rotationZ = angle
        },
        imageVector = EnIcons.Loader,
        contentDescription = "Loading icon",
    )
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

@Preview(name = "Loading button with text")
@Composable
fun LoadingButtonPreview() {
    MainButton(
        text = "Войти",
        onClick = {},
        isLoading = true,
    )
}

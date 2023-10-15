package com.enplus.energetic.ui.components.base

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.icons.EnIcons
import com.enplus.energetic.ui.icons.Loader
import com.enplus.energetic.ui.theme.EnColor

@Composable
fun LoadingButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
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
        Box(
            contentAlignment = Alignment.Center,
        ) {
            if (isLoading) {
                LoadingIndicator()
            } else {
                Text(
                    text = text,
                    fontSize = 17.sp,
                )
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

@Preview(name = "Enabled loading button with text")
@Composable
fun LoadingButtonPreview() {
    LoadingButton(
        text = "Войти",
        onClick = {},
    )
}

@Preview(name = "Is loading button with text")
@Composable
fun IsLoadingButtonPreview() {
    LoadingButton(
        text = "Войти",
        onClick = {},
        isLoading = true,
    )
}

@Preview(name = "Disabled loading button with text")
@Composable
fun LoadingDisabledButtonPreview() {
    LoadingButton(
        text = "Войти",
        onClick = {},
        isEnabled = false,
    )
}

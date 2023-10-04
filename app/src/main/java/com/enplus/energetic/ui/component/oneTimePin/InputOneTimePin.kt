package com.enplus.energetic.ui.component.oneTimePin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.theme.Orange

@Composable
fun InputOneTimePin(
    modifier: Modifier = Modifier,
    dotDp: Dp = 16.dp,
    dpActiveColor: Color = Orange,
    pinLength: Int = 4,
    pinInputtedLength: Int,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        repeat(pinLength) {
            Box(
                modifier = Modifier
                    .size(dotDp)
                    .clip(CircleShape)
                    .background(if (it < pinInputtedLength) dpActiveColor else Color.Gray),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InputOneTimePinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            modifier = Modifier.padding(horizontal = 80.dp),
            pinInputtedLength = 0,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InputOneTimePinWithInputtedPinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            modifier = Modifier.padding(horizontal = 80.dp),
            pinInputtedLength = 3,
        )
    }
}

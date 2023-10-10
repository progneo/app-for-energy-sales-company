package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.theme.Orange

@Composable
fun InputOneTimePin(
    modifier: Modifier = Modifier,
    dpActiveColor: Color = Orange,
    pinLength: Int = 4,
    pinInputtedLength: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = modifier,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            repeat(pinLength) {
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(if (it < pinInputtedLength) dpActiveColor else Color.Gray),
                )
            }
        }
    }
}

@Preview(name = "Empty input PIN")
@Composable
fun InputOneTimePinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            pinInputtedLength = 0,
        )
    }
}

@Preview(name = "Inputting PIN")
@Composable
fun InputOneTimePinWithInputtedPinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            pinInputtedLength = 3,
        )
    }
}

package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.R
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.ui.theme.Orange

@Composable
fun InputOneTimePin(
    modifier: Modifier = Modifier,
    title: String,
    dpActiveColor: Color = Orange,
    pinLength: Int = 4,
    pinInputtedLength: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall.copy(
                fontSize = 19.sp,
                fontWeight = FontWeight.Medium,
            ),
        )

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
            title = stringResource(id = R.string.input_pin),
            pinInputtedLength = 0,
        )
    }
}

@Preview(name = "Inputting PIN")
@Composable
fun InputOneTimePinWithInputtedPinPreview() {
    EnergeticTheme {
        InputOneTimePin(
            title = stringResource(id = R.string.input_pin),
            pinInputtedLength = 3,
        )
    }
}

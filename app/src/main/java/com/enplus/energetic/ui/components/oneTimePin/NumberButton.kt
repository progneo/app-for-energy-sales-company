package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.theme.LightGray

@Composable
internal fun NumberButton(
    modifier: Modifier = Modifier,
    value: Int,
    onNumberClick: (Int) -> Unit,
) {
    Box(
        modifier = modifier
            .size(80.dp)
            .clip(CircleShape)
            .background(LightGray)
            .clickable { onNumberClick(value) },
    ) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = value.toString(),
            style = MaterialTheme.typography.headlineMedium.copy(
                fontWeight = FontWeight.Medium,
                fontSize = 36.sp,
            ),
        )
    }
}

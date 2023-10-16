package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.enplus.energetic.ui.icon.Backspace

@Composable
internal fun BackspaceButton(
    onBackspaceButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .clickable { onBackspaceButtonClick() },
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp)
                .align(Alignment.Center),
            imageVector = Icons.Backspace,
            contentDescription = "backspace",
        )
    }
}

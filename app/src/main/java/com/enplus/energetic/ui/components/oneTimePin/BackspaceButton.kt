package com.enplus.energetic.ui.components.oneTimePin

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.enplus.energetic.ui.icon.Backspace

@Composable
internal fun BackspaceButton(
    onBackspaceButtonClick: () -> Unit,
) {
    Box {
        IconButton(
            modifier = Modifier
                .align(Alignment.Center),
            onClick = { onBackspaceButtonClick() },
        ) {
            Icon(
                imageVector = Icons.Backspace,
                contentDescription = "backspace",
            )
        }
    }
}

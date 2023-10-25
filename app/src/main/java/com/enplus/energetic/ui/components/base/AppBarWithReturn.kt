package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enplus.energetic.ui.icon.ArrowLeft
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun TopBarWithReturn(
    onBackClick: () -> Unit,
    arrowColor: Color = EnColor.Orange,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 16.dp)
            .height(64.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(
            modifier = Modifier.size(48.dp),
            onClick = onBackClick,
        ) {
            Icon(
                modifier = Modifier.size(24.dp),
                imageVector = EnIcons.ArrowLeft,
                contentDescription = null,
                tint = arrowColor,
            )
        }
    }
}

@Preview(name = "Top Bar")
@Composable
fun TopBarPreview() {
    EnergeticTheme {
        TopBarWithReturn(
            onBackClick = {},
        )
    }
}

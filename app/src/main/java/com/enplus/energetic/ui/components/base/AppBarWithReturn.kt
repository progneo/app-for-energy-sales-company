package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.enplus.energetic.ui.icon.ArrowLeft
import com.enplus.energetic.ui.icon.EnIcons
import com.enplus.energetic.ui.theme.EnColor
import com.enplus.energetic.ui.theme.EnergeticTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithReturn(
    onBackClick: () -> Unit,
    arrowColor: Color = EnColor.Orange,
    backgroundColor: Color = Color.White,
    action: (@Composable () -> Unit)? = null,
) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backgroundColor,
        ),
        title = { },
        navigationIcon = {
            IconButton(
                onClick = { onBackClick() },
                content = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        imageVector = EnIcons.ArrowLeft,
                        contentDescription = "Назад",
                        tint = arrowColor,
                    )
                },
            )
        },
        actions = {
            action?.invoke()
        },
    )
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

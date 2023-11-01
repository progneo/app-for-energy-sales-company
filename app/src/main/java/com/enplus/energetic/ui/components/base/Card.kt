package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.enplus.energetic.ui.theme.EnColor
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Card(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = EnColor.Background,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        ),
        onClick = { onClick?.let { onClick() } },
    ) {
        content()
    }
}
package com.enplus.energetic.ui.components.base

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enplus.energetic.ui.theme.EnColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChip(
    label: String,
    imageVector: ImageVector,
    selected: Boolean,
    onClick: () -> Unit,
) {
    FilterChip(
        selected = selected,
        onClick = { onClick() },
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = "",
                tint = EnColor.Orange,
            )
        },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = EnColor.TextTitle,
                ),
            )
        },
        shape = RoundedCornerShape(1000.dp),
        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = EnColor.OrangeBackground,
            containerColor = EnColor.LightGray_Medium,
        ),
        border = FilterChipDefaults.filterChipBorder(
            borderColor = EnColor.OrangeBackground,
        ),
    )
}

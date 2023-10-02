package com.enplus.energetic.ui.components.navigation

import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationItem(
    val route: String,
    val titleResId: Int,
    val icon: ImageVector,
)

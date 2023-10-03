package com.enplus.energetic.ui.components.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.Work
import androidx.compose.ui.graphics.vector.ImageVector
import com.enplus.energetic.R
import com.enplus.energetic.util.NavDestinations

sealed class BottomNavigationItem(
    val route: String,
    val titleResId: Int,
    val icon: ImageVector,
) {
    data object Data : BottomNavigationItem(
        route = NavDestinations.DATA_SCREEN,
        titleResId = R.string.data,
        icon = Icons.Rounded.Work,
    )

    data object Account : BottomNavigationItem(
        route = NavDestinations.ACCOUNT_SCREEN,
        titleResId = R.string.account,
        icon = Icons.Rounded.AccountBox,
    )
}

package com.enplus.energetic.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enplus.energetic.ui.screen.account.AccountScreen
import com.enplus.energetic.ui.screen.data.DataScreen
import com.enplus.energetic.util.NavDestinations

@Composable
fun BottomNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavDestinations.DATA_SCREEN,
    ) {
        composable(route = NavDestinations.DATA_SCREEN) {
            DataScreen(navController = navController)
        }
        composable(route = NavDestinations.ACCOUNT_SCREEN) {
            AccountScreen()
        }
    }
}

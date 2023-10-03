package com.enplus.energetic.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enplus.energetic.ui.screen.login.LoginScreen
import com.enplus.energetic.ui.screen.main.MainScreen
import com.enplus.energetic.ui.screen.oneTimePin.OneTimePinScreen
import com.enplus.energetic.util.NavDestinations

@Composable
fun NavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavDestinations.MAIN_SCREEN,
    ) {
        composable(route = NavDestinations.MAIN_SCREEN) {
            MainScreen()
        }
        composable(route = NavDestinations.ONE_TIME_PIN_SCREEN) {
            OneTimePinScreen()
        }
        composable(route = NavDestinations.LOGIN_SCREEN) {
            LoginScreen()
        }
    }
}

package com.enplus.energetic.ui.component.navigation

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
    isAuthorized: Boolean,
) {
    NavHost(
        navController = navController,
        startDestination = if (isAuthorized) {
            NavDestinations.ONE_TIME_PIN_SCREEN
        } else {
            NavDestinations.LOGIN_SCREEN
        },
    ) {
        composable(route = NavDestinations.LOGIN_SCREEN) {
            LoginScreen(navController = navController)
        }
        composable(route = NavDestinations.ONE_TIME_PIN_SCREEN) {
            OneTimePinScreen()
        }
        composable(route = NavDestinations.MAIN_SCREEN) {
            MainScreen()
        }
    }
}

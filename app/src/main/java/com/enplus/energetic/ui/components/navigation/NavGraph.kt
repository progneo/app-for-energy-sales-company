package com.enplus.energetic.ui.components.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.enplus.energetic.ui.screen.data.DataScreen
import com.enplus.energetic.ui.screen.login.LoginScreen
import com.enplus.energetic.ui.screen.main.MainScreen
import com.enplus.energetic.ui.screen.oneTimePin.OneTimePinScreen
import com.enplus.energetic.util.NavDestinations

@RequiresApi(Build.VERSION_CODES.O)
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
            OneTimePinScreen(navController = navController)
        }
        composable(route = NavDestinations.MAIN_SCREEN) {
            MainScreen()
        }
        composable(route = NavDestinations.DATA_SCREEN) {
            DataScreen(navController = navController)
        }
    }
}

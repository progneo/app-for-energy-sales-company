package com.enplus.energetic.ui.components.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.enplus.energetic.ui.entities.PersonDataArgType
import com.enplus.energetic.ui.screen.addressData.AddressDataScreen
import com.enplus.energetic.ui.screen.camera.CameraScreen
import com.enplus.energetic.ui.screen.camera.confirmation.ConfirmationScreen
import com.enplus.energetic.ui.screen.data.DataScreen
import com.enplus.energetic.ui.screen.login.LoginScreen
import com.enplus.energetic.ui.screen.main.MainScreen
import com.enplus.energetic.ui.screen.oneTimePin.OneTimePinScreen
import com.enplus.energetic.ui.util.NavDestinations

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
            MainScreen(navController = navController)
        }
        composable(
            route = "${NavDestinations.DATA_SCREEN}/{personData}",
            arguments = listOf(
                navArgument("personData") {
                    type = PersonDataArgType()
                },
            ),
        ) {
            DataScreen(navController = navController)
        }
        composable(route = NavDestinations.CAMERA_SCREEN) {
            CameraScreen(navController = navController)
        }
        composable(route = NavDestinations.ADDRESS_DATA_SCREEN) {
            AddressDataScreen(navController = navController)
        }
        composable(route = "${NavDestinations.CONFIRMATION_SCREEN}/{id}") {
            val id = it.arguments?.getString("id") ?: ""
            ConfirmationScreen(navController = navController, accountNumber = id)
        }
    }
}

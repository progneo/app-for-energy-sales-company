package com.enplus.energetic

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.enplus.energetic.data.preference.AuthStateManager
import com.enplus.energetic.ui.component.navigation.NavGraph
import com.enplus.energetic.ui.theme.EnergeticTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authStateManager: AuthStateManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setWindowSecurity()

        installSplashScreen()

        setContent {
            EnergeticTheme {
                Surface {
                    val navController = rememberNavController()
                    NavGraph(
                        navController = navController,
                        isAuthorized = authStateManager.authState,
                    )
                }
            }
        }
    }

    private fun setWindowSecurity() {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_SECURE,
            WindowManager.LayoutParams.FLAG_SECURE
        )
    }
}

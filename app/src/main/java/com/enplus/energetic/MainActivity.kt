package com.enplus.energetic

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.enplus.energetic.data.preference.AuthStateManagerImpl
import com.enplus.energetic.ui.component.navigation.NavGraph
import com.enplus.energetic.ui.theme.EnergeticTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var authStateManager: AuthStateManagerImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setWindowSecurity()

        installSplashScreen()
        CoroutineScope(Dispatchers.IO).launch {
            val authState = async { authStateManager.get() }.await()

            withContext(Dispatchers.Main) {
                setContent {
                    EnergeticTheme {
                        Surface {
                            val navController = rememberNavController()
                            NavGraph(
                                navController = navController,
                                isAuthorized = authState,
                            )
                        }
                    }
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

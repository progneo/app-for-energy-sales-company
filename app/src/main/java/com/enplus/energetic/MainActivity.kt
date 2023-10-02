package com.enplus.energetic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.enplus.energetic.ui.screen.main.MainScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.enplus.energetic.ui.theme.EnergeticTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            EnergeticTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

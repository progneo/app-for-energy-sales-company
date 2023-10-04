package com.enplus.energetic.ui.screen.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.enplus.energetic.ui.component.navigation.BottomNavGraph
import com.enplus.energetic.ui.component.navigation.BottomNavigationBar
import com.enplus.energetic.ui.theme.EnergeticTheme

@Composable
fun MainScreen() {
    val bottomNavController = rememberNavController()

    Scaffold(
        content = {
            Box(modifier = Modifier.padding(it)) {
                BottomNavGraph(bottomNavController)
            }
        },
        bottomBar = {
            BottomNavigationBar(navController = bottomNavController)
        },
    )
}

@Preview(name = "Main screen")
@Composable
fun MainScreenPreview() {
    EnergeticTheme {
        MainScreen()
    }
}

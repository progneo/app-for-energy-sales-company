package com.enplus.energetic.ui.components.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.enplus.energetic.ui.theme.EnergeticTheme
import com.enplus.energetic.util.NavDestinations

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val bottomNavigationItems = listOf(
        BottomNavigationItem.Data,
        BottomNavigationItem.Account,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar {
        bottomNavigationItems.forEach { item ->
            AddItem(
                bottomNavigationItem = item,
                navBackStackEntry = navBackStackEntry,
                navController = navController,
            )
        }
    }
}

@Composable
fun RowScope.AddItem(
    bottomNavigationItem: BottomNavigationItem,
    navBackStackEntry: NavBackStackEntry?,
    navController: NavHostController,
) {
    val selected = bottomNavigationItem.route == navBackStackEntry?.destination?.route
    NavigationBarItem(
        modifier = Modifier.navigationBarsPadding(),
        icon = {
            Icon(
                imageVector = bottomNavigationItem.icon,
                contentDescription = "${bottomNavigationItem.titleResId} Icon",
            )
        },
        label = { Text(stringResource(bottomNavigationItem.titleResId)) },
        selected = selected,
        alwaysShowLabel = true,
        onClick = {
            if (navController.currentDestination?.route != bottomNavigationItem.route) {
                navController.navigate(bottomNavigationItem.route) {
                    launchSingleTop = true
                    popUpTo(NavDestinations.DATA_SCREEN)
                }
            }
        },
    )
}

@Preview(name = "Navigation bar")
@Composable
fun BottomNavigationBarPreview() {
    EnergeticTheme {
        BottomNavigationBar(navController = rememberNavController())
    }
}

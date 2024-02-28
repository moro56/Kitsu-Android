package com.app.kitsu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.kitsu.models.Screens

/**
 * Bottom navigation bar
 *
 * @param navController navigation controller
 */
@Composable
fun BottomNavBar(navController: NavHostController) {
    val screens =
        remember { listOf(Screens.AnimeScreen, Screens.MangaScreen, Screens.CategoriesScreen) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    NavigationBar {
        val currentRoute = navBackStackEntry?.destination?.route

        screens.forEach { screen ->
            val selected = currentRoute?.startsWith(screen.route) == true

            NavigationBarItem(
                label = {
                    Text(text = stringResource(id = screen.title))
                },
                icon = {
                    Image(
                        imageVector = screen.icon,
                        contentDescription = stringResource(id = screen.title)
                    )
                },
                selected = selected,
                onClick = {
                    navController.navigate(screen.route) {
                        navController.graph.findStartDestination().route?.also {
                            popUpTo(it) {
                                inclusive = false
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Preview
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(rememberNavController())
}

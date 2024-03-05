package com.app.kitsu.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.models.NavDestination
import com.app.feature.anime.AnimeFeature
import com.app.feature.categories.CategoriesFeature
import com.app.feature.manga.MangaFeature

/**
 * NavHost component that defines the navigation graph
 *
 * @param modifier compose modifier
 * @param navController navigation controller
 */
@Composable
fun AppGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    val appNavigator = remember { AppNavigator(navController = navController) }

    NavHost(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        navController = navController,
        startDestination = NavDestination.Anime.route
    ) {
        composable(NavDestination.Anime.route) {
            AnimeFeature(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavDestination.Manga.route) {
            MangaFeature(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavDestination.Categories.route) {
            CategoriesFeature(appNavigator = appNavigator, modifier = modifier)
        }
    }
}

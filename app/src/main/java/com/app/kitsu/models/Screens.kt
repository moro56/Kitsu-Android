package com.app.kitsu.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.core.navigation.models.NavDestination

sealed class Screens(val route: String, @StringRes val title: Int, val icon: ImageVector) {
    data object AnimeScreen : Screens(
        NavDestination.Anime.route,
        android.R.string.copy,
        Icons.Filled.Home
    )

    data object MangaScreen : Screens(
        NavDestination.Manga.route,
        android.R.string.cancel,
        Icons.Filled.Star
    )

    data object CategoriesScreen : Screens(
        NavDestination.Categories.route,
        android.R.string.cancel,
        Icons.Filled.Settings
    )
}

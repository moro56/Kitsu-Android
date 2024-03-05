package com.app.kitsu.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.app.core.navigation.models.NavDestination

sealed class Screens(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    data object AnimeScreen : Screens(
        NavDestination.Anime.route,
        com.app.core.base.R.string.tab_anime,
        com.app.ui.R.drawable.ic_anime
    )

    data object MangaScreen : Screens(
        NavDestination.Manga.route,
        com.app.core.base.R.string.tab_manga,
        com.app.ui.R.drawable.ic_manga
    )

    data object CategoriesScreen : Screens(
        NavDestination.Categories.route,
        com.app.core.base.R.string.tab_categories,
        com.app.ui.R.drawable.ic_categories
    )
}

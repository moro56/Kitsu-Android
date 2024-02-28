package com.app.core.navigation.models

import androidx.navigation.NamedNavArgument

/**
 * Class that defines all the features route
 *
 * @property route route of the feature
 * @property arguments arguments of the feature
 */
sealed class NavDestination(
    val route: String,
    open val arguments: List<NamedNavArgument> = emptyList()
) {
    /**
     * Anime Feature
     */
    data object Anime : NavDestination(route = "anime")

    /**
     * Manga Feature
     */
    data object Manga : NavDestination(route = "manga")

    /**
     * Categories Feature
     */
    data object Categories : NavDestination(route = "categories")
}

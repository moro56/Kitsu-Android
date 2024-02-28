package com.app.feature.anime

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.feature.anime.ui.AnimeScreen

@Composable
fun AnimeFeature(appNavigator: Navigator, modifier: Modifier) {
    AnimeScreen(modifier = modifier)
}

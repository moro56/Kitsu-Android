package com.app.feature.manga

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.feature.manga.ui.MangaScreen

@Composable
fun MangaFeature(appNavigator: Navigator, modifier: Modifier) {
    MangaScreen(modifier = modifier)
}

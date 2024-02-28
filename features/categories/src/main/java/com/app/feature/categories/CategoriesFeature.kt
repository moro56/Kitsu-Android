package com.app.feature.categories

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.feature.categories.ui.CategoriesScreen

@Composable
fun CategoriesFeature(appNavigator: Navigator, modifier: Modifier) {
    CategoriesScreen(modifier = modifier)
}

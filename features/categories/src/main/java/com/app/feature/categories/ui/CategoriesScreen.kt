package com.app.feature.categories.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Categories screen
 *
 * @param modifier compose modifier
 */
@Composable
fun CategoriesScreen(modifier: Modifier) {
    CategoriesScreenContent(modifier = modifier)
}

/**
 * Categories screen content
 *
 * @param modifier compose modifier
 */
@Composable
fun CategoriesScreenContent(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Categories")
    }
}

@Preview
@Composable
fun CategoriesScreenContentPreview() {
    CategoriesScreenContent(Modifier)
}

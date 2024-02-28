package com.app.feature.anime.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Anime screen
 *
 * @param modifier compose modifier
 */
@Composable
fun AnimeScreen(modifier: Modifier) {
    AnimeScreenContent(modifier = modifier)
}

/**
 * Anime screen content
 *
 * @param modifier compose modifier
 */
@Composable
fun AnimeScreenContent(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Anime")
    }
}

@Preview
@Composable
fun AnimeScreenContentPreview() {
    AnimeScreenContent(Modifier)
}

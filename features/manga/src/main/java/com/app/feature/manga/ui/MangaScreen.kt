package com.app.feature.manga.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/**
 * Manga screen
 *
 * @param modifier compose modifier
 */
@Composable
fun MangaScreen(modifier: Modifier) {
    MangaScreenContent(modifier = modifier)
}

/**
 * Manga screen content
 *
 * @param modifier compose modifier
 */
@Composable
fun MangaScreenContent(modifier: Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(text = "Manga")
    }
}

@Preview
@Composable
fun MangaScreenContentPreview() {
    MangaScreenContent(Modifier)
}

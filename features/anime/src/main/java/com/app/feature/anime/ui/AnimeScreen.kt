package com.app.feature.anime.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.core.ui.Loading
import com.app.core.ui.preview.ThemePreviewWrapper

/**
 * Anime screen
 *
 * @param modifier compose modifier
 * @param viewModel viewModel
 */
@Composable
fun AnimeScreen(modifier: Modifier, viewModel: AnimeViewModel = hiltViewModel()) {
    // ViewModel state
    val uiState = viewModel.uiState.collectAsState()

    AnimeScreenContent(modifier = modifier, state = uiState.value)
}

/**
 * Anime screen content
 *
 * @param modifier compose modifier
 */
@Composable
fun AnimeScreenContent(modifier: Modifier, state: AnimeContract.State) {
    Box(modifier = modifier) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state.animeList, key = { i -> i.id }) {
                AnimeItem(anime = it)
            }
        }

        if (state.loading) {
            Loading(showShadow = false, disableClick = false)
        }
    }
}

@Preview
@Composable
fun AnimeScreenContentPreview() {
    ThemePreviewWrapper {
        AnimeScreenContent(Modifier, animeStateMock)
    }
}

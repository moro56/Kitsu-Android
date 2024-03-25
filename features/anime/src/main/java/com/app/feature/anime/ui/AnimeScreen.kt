package com.app.feature.anime.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.app.core.base.R
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
 * @param state viewModel state value
 */
@Composable
fun AnimeScreenContent(modifier: Modifier, state: AnimeContract.State) {
    val animeData = state.animeData.collectAsLazyPagingItems()
    val gridState = rememberLazyGridState()
    // Show different loading view depending if is first load or not
    val isFirstLoading by remember {
        derivedStateOf {
            gridState.layoutInfo.totalItemsCount == 0
        }
    }

    Box(modifier = modifier) {
        LazyVerticalGrid(
            state = gridState,
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(animeData.itemCount) {
                animeData[it]?.also { anime ->
                    AnimeItem(anime = anime)
                }
            }

            animeData.apply {
                when {
                    !isFirstLoading && (loadState.refresh is LoadState.Loading || loadState.append is LoadState.Loading) -> {
                        item(span = { GridItemSpan(3) }) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator(
                                    Modifier.semantics { contentDescription = "pagination loading" }
                                )
                            }
                        }
                    }

                    loadState.refresh is LoadState.Error || loadState.append is LoadState.Error -> {
                        item(span = { GridItemSpan(2) }) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(12.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Button(onClick = { retry() }) { Text(text = stringResource(id = R.string.anime_retry_button)) }
                            }
                        }
                    }

                    else -> {}
                }
            }
        }

        if (isFirstLoading) {
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

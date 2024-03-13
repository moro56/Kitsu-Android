package com.app.feature.anime.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.core.data.models.Anime
import com.app.core.data.models.animeMockData

@Composable
fun AnimeItem(anime: Anime) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(modifier = Modifier.padding(16.dp), text = anime.slug)
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeItemPreview() {
    AnimeItem(animeMockData)
}

package com.app.feature.anime.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.core.data.models.Anime
import com.app.core.data.models.animeMockData
import com.app.core.ui.AppImage
import com.app.core.ui.preview.ThemePreviewWrapper

@Composable
fun AnimeItem(anime: Anime) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppImage(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(0.65f)
                .clip(RoundedCornerShape(12.dp)),
            imageUrl = anime.posterImage.small
        )
        Text(
            modifier = Modifier.padding(top = 2.dp),
            text = anime.title,
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AnimeItemPreview() {
    ThemePreviewWrapper {
        AnimeItem(animeMockData)
    }
}

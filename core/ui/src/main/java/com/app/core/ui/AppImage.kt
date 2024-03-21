package com.app.core.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun AppImage(modifier: Modifier, imageUrl: String) {
    GlideImage(
        modifier = modifier,
        imageModel = { imageUrl },
        imageOptions = ImageOptions(
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        ),
        loading = { Box(contentAlignment = Alignment.Center) { CircularProgressIndicator() } },
        failure = {
            Box(contentAlignment = Alignment.Center) {
                Icon(Icons.Filled.Warning, contentDescription = null)
            }
        }
    )
}

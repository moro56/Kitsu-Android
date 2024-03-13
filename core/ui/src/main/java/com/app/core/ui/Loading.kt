package com.app.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

/**
 * Loading progress bar
 *
 * @param showShadow show or hide transparent dark background
 * @param disableClick intercept or not the click when the loading is showing
 */
@Composable
fun Loading(showShadow: Boolean = true, disableClick: Boolean = true) {
    val interactiveSource = remember { MutableInteractionSource() }
    val shadowModifier = if (showShadow) {
        Modifier.background(Color.Transparent.copy(alpha = 0.4f))
    } else Modifier
    val clickableModifier = if (disableClick) {
        Modifier.clickable(
            interactionSource = interactiveSource,
            indication = null,
            onClick = {}
        )
    } else Modifier

    Box(
        modifier = Modifier
            .fillMaxSize()
            .then(shadowModifier)
            .then(clickableModifier),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun LoadingPreview() {
    Loading()
}

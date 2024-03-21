package com.app.core.ui.preview

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import com.app.core.ui.LocalSnackBarHostState
import com.app.core.ui.theme.AppTheme

@Composable
fun ThemePreviewWrapper(content: @Composable () -> Unit) {
    val snackBarHostState = remember { SnackbarHostState() }

    AppTheme {
        CompositionLocalProvider(LocalSnackBarHostState provides snackBarHostState) {
            Surface(
                color = MaterialTheme.colorScheme.background,
                content = content
            )
        }
    }
}

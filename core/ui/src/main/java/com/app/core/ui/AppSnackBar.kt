package com.app.core.ui

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf

val LocalSnackBarHostState =
    compositionLocalOf<SnackbarHostState> { error("No SnackBarHostState provided") }

@Composable
fun AppSnackBar(state: SnackbarHostState) {
    SnackbarHost(hostState = state) {
        Snackbar(snackbarData = it)
    }
}

package com.app.kitsu.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.core.ui.AppSnackBar
import com.app.core.ui.LocalSnackBarHostState
import com.app.kitsu.navigation.AppGraph
import com.app.kitsu.ui.components.BottomNavBar

/**
 * Main screen
 *
 * @param navController navigation controller
 */
@Composable
fun MainScreen(navController: NavHostController = rememberNavController()) {
    val snackBarHostState = remember { SnackbarHostState() }

    CompositionLocalProvider(LocalSnackBarHostState provides snackBarHostState) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = { BottomNavBar(navController = navController) },
            snackbarHost = { AppSnackBar(state = snackBarHostState) }
        ) {
            AppGraph(
                navController = navController,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            )
        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    MainScreen()
}

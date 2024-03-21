package com.app.core.ui

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.launch
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppSnackBarTest {

    @get:Rule
    internal var composeTestRule = createComposeRule()

    @Test
    fun `snackBar shows correctly`() {
        composeTestRule.setContent {
            val coroutineScope = rememberCoroutineScope()
            val snackBarHostState = remember { SnackbarHostState() }
            AppSnackBar(state = snackBarHostState)
            LaunchedEffect(Unit) {
                coroutineScope.launch {
                    snackBarHostState.showSnackbar("message", "action")
                }
            }
        }

        InstrumentationRegistry.getInstrumentation().waitForIdleSync()
        composeTestRule.onNodeWithText("message").assertIsDisplayed()
        composeTestRule.onNodeWithText("action").assertIsDisplayed()
    }
}

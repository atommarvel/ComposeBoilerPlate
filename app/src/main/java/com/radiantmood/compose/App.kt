package com.radiantmood.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

val LocalNavController = compositionLocalOf<NavHostController> { error("LocalNavController was not initialized") }

@Composable
fun App() {
    CompositionLocalProvider(
        LocalNavController provides rememberNavController()
    ) {
        NavHost(LocalNavController.current, startDestination = HomeScreen.route) {
            composableScreen(HomeScreen)
        }
    }
}


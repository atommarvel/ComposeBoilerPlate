package com.radiantmood.compose

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate

fun NavGraphBuilder.composableScreen(composableScreen: ComposableScreen) {
    composable(composableScreen.route, composableScreen.arguments, composableScreen.deepLinks, composableScreen.content)
}

fun NavHostController.navigate(composableScreen: ComposableScreen, builder: NavOptionsBuilder.() -> Unit = {} ) {
    navigate(composableScreen.route, builder)
}
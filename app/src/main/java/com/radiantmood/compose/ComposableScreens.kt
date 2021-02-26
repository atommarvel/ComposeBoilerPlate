package com.radiantmood.compose

import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.compose.NamedNavArgument
import com.radiantmood.compose.screens.home.HomeScreenRoot

sealed class ComposableScreen(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList(),
    val deepLinks: List<NavDeepLink> = emptyList(),
    val content: @Composable (NavBackStackEntry) -> Unit
)

object HomeScreen : ComposableScreen(route = "homeScreen", content = { HomeScreenRoot() })


package com.radiantmood.compose.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.vector.ImageVector
import com.radiantmood.compose.LocalNavController

// Is this worthwhile?
val LocalAppBarTitle = compositionLocalOf<String> { error("LocalAppBarTitle is not initialized") }

@Composable
fun MyTopAppBar(actions: @Composable () -> Unit = {}) {
    TopAppBar(
        title = { Text(LocalAppBarTitle.current) },
        navigationIcon = { NavBack() },
        actions = { actions() }
    )
}

@Composable
fun AppBarAction(imageVector: ImageVector, onClick: () -> Unit) {
    IconButton(onClick) {
        Icon(imageVector, null) // TODO: null
    }
}

@Composable
fun NavBack() {
    val navController = LocalNavController.current
    if (navController.previousBackStackEntry != null) {
        AppBarAction(imageVector = Icons.Default.ArrowBack, onClick = { navController.popBackStack() })
    }
}
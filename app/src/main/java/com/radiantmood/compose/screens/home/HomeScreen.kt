package com.radiantmood.compose.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import com.radiantmood.compose.screens.LoadingModelContainer
import com.radiantmood.compose.screens.ModelContainer
import com.radiantmood.compose.ui.Fullscreen
import com.radiantmood.compose.ui.LocalAppBarTitle
import com.radiantmood.compose.ui.ModelContainerContent
import com.radiantmood.compose.ui.MyTopAppBar

val LocalHomeViewModel = compositionLocalOf<HomeViewModel> { error("LocalHomeViewModel was not initialized.") }

@Composable
fun HomeScreenRoot() {
    val vm: HomeViewModel = viewModel()
    vm.fetch()
    CompositionLocalProvider(
        LocalHomeViewModel provides vm,
        LocalAppBarTitle provides "My Compose App"
    ) {
        HomeScreenContent()
    }
}

@Composable
fun HomeScreenContent() {
    val vm: HomeViewModel = LocalHomeViewModel.current
    val modelContainer: ModelContainer<HomeScreenModel> by vm.screenModel.observeAsState(LoadingModelContainer())
    Column {
        MyTopAppBar()
        ModelContainerContent(modelContainer) { HomeScreenContentFinished(it) }
    }
}

@Composable
fun HomeScreenContentFinished(screenModel: HomeScreenModel) = Fullscreen {
    Text(screenModel.message)
}
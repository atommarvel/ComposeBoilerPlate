package com.radiantmood.compose.screens.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.radiantmood.compose.screens.FinishedModelContainer
import com.radiantmood.compose.screens.LoadingModelContainer
import com.radiantmood.compose.screens.ModelContainer
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

data class HomeScreenModel(val message: String) : FinishedModelContainer<HomeScreenModel>()

class HomeViewModel: ViewModel() {
    private val _screenModel = MutableLiveData<ModelContainer<HomeScreenModel>>()
    val screenModel: LiveData<ModelContainer<HomeScreenModel>> = _screenModel

    fun fetch() {
        _screenModel.value = LoadingModelContainer()
        viewModelScope.launch {
            delay(TimeUnit.SECONDS.toMillis(5))
            _screenModel.postValue(HomeScreenModel("This is your home screen!"))
        }
    }
}
package com.radiantmood.compose.screens

sealed class ModelContainer<T>

class LoadingModelContainer<T>: ModelContainer<T>()
class ErrorModelContainer<T>(val errorMessage: String? = null): ModelContainer<T>()
open class FinishedModelContainer<T>: ModelContainer<T>()
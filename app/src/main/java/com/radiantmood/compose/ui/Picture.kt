package com.radiantmood.compose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import coil.imageLoader
import coil.request.ImageRequest

@Composable
fun Picture(
    url: String,
    preLoaded: @Composable () -> Unit = {},
    error: @Composable () -> Unit = {}, // TODO: incorporate error
    content: @Composable (image: ImageBitmap) -> Unit
) {
    val context = LocalContext.current
    composableFetch {
        val req = ImageRequest.Builder(context).data(url).build()
        context.imageLoader.execute(req).drawable
    }?.let { drawable ->
        content(drawable.toBitmap().asImageBitmap())
    } ?: run {
        preLoaded()
    }
}
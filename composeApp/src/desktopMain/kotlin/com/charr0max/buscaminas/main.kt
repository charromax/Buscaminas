package com.charr0max.buscaminas

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.charr0max.buscaminas.data.core.storage.createDataStore

fun main() = application {
    val dataStore = createDataStore()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Buscaminas",
    ) {
        App()
    }
}
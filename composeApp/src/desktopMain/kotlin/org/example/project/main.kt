package org.example.project

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.project.data.game.createDataStore

fun main() = application {
    val dataStore = createDataStore()
    Window(
        onCloseRequest = ::exitApplication,
        title = "Buscaminas",
    ) {
        App()
    }
}
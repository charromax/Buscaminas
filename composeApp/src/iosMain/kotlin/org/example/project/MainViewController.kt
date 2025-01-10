package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import com.example.project.data.game.createDataStore

fun MainViewController() = ComposeUIViewController {
    val dataStore = createDataStore()
    App()
}
package org.example.project

import androidx.compose.ui.window.ComposeUIViewController
import com.example.project.data.core.storage.createDataStore

fun MainViewController() = ComposeUIViewController {
    val dataStore = createDataStore()
    App()
}
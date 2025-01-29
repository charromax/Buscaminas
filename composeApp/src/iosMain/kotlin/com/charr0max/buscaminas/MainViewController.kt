package com.charr0max.buscaminas

import androidx.compose.ui.window.ComposeUIViewController
import com.charr0max.buscaminas.data.core.storage.createDataStore

fun MainViewController() = ComposeUIViewController {
    val dataStore = createDataStore()
    App()
}
package com.charr0max.buscaminas.settings.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object Settings

fun NavGraphBuilder.settingsRoutes() {
    composable<Settings> {
        val viewModel: SettingsScreenViewModel = koinViewModel()
        SettingsScreen(modifier = Modifier.fillMaxSize(), viewModel = viewModel)
    }
}
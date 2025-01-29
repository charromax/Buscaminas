package com.charr0max.buscaminas.feature.menu

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Serializable
data object Menu

fun NavGraphBuilder.menuRoutes(
    goToPlay: () -> Unit,
    goToHighscore: () -> Unit,
    goToSettings: () -> Unit
) {
    composable<Menu> {
        MenuScreen(
            modifier = Modifier.fillMaxSize(),
            goToPlay = goToPlay,
            goToHighscore = goToHighscore,
            goToSettings = goToSettings
        )
    }
}
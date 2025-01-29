package com.charr0max.buscaminas.feature.highscore

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import org.koin.compose.viewmodel.koinViewModel

@Serializable
data object HighScore

fun NavGraphBuilder.highScoreRoutes() {
    composable<HighScore> {
        val viewModel: HighScoreViewModel = koinViewModel()
        HighScoreScreen(
            viewModel = viewModel,
            modifier = Modifier.fillMaxSize()
        )
    }
}

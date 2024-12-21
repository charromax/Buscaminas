package com.example.project.feature.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.example.project.feature.menu.components.MenuButton
import com.example.project.ui.core.LocalPadding

@Composable
internal fun MenuScreen(
    modifier: Modifier = Modifier,
    goToPlay: () -> Unit,
    goToHighscore: () -> Unit,
    goToSettings: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MenuButton(label = "Go to play", action = goToPlay)
        MenuButton(label = "Go to settings", action = goToSettings)
        MenuButton(label = "Go to highscore", action = goToHighscore)
    }
}
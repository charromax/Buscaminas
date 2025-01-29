package com.charr0max.buscaminas.feature.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import com.charr0max.buscaminas.feature.menu.components.MenuButton

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
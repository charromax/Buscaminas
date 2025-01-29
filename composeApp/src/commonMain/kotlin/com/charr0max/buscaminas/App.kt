package com.charr0max.buscaminas

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.charr0max.buscaminas.feature.highscore.HighScore
import com.charr0max.buscaminas.feature.highscore.highScoreRoutes
import com.charr0max.buscaminas.feature.menu.Menu
import com.charr0max.buscaminas.feature.menu.menuRoutes
import com.charr0max.buscaminas.settings.ui.Settings
import com.charr0max.buscaminas.settings.ui.settingsRoutes
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.core.module.Module

@Composable
@Preview
fun App(
    platformModule: Module = Module()
) {
    KoinApplication(application = {
        modules(appModule, platformModule)
    }) {
        MaterialTheme {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Menu,
            ) {
                menuRoutes(goToPlay = { },
                    goToHighscore = { navController.navigate(HighScore) },
                    goToSettings = { navController.navigate(Settings) })
                highScoreRoutes()
                settingsRoutes()
//                playRoutes()
            }
        }
    }
}


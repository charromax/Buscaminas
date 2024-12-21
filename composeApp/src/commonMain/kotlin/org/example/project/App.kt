package org.example.project

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.project.feature.highscore.HighScore
import com.example.project.feature.highscore.highScoreRoutes
import com.example.project.feature.menu.Menu
import com.example.project.feature.menu.menuRoutes
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
                    goToSettings = { })
                highScoreRoutes()
//                settingsRoutes()
//                playRoutes()
            }
        }
    }
}


package org.example.project

import com.example.project.feature.highscore.highScoreModule
import com.example.project.feature.menu.menuModule
import com.example.project.feature.play.playModule
import com.example.project.settings.settingsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        highScoreModule,
        settingsModule,
        menuModule,
        playModule
    )
}
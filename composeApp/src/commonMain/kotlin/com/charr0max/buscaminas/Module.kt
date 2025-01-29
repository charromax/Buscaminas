package com.charr0max.buscaminas

import com.charr0max.buscaminas.feature.highscore.highScoreModule
import com.charr0max.buscaminas.feature.menu.menuModule
import com.charr0max.buscaminas.feature.play.playModule
import com.charr0max.buscaminas.settings.settingsModule
import org.koin.dsl.module

val appModule = module {
    includes(
        highScoreModule,
        settingsModule,
        menuModule,
        playModule
    )
}
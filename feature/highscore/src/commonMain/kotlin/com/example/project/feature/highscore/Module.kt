package com.example.project.feature.highscore

import com.example.project.domain.game.domainGameModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val highScoreModule = module {
    includes(domainGameModule)
    viewModelOf(::HighScoreViewModel)
}
package com.charr0max.buscaminas.feature.highscore

import com.charr0max.buscaminas.domain.game.domainGameModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val highScoreModule = module {
    includes(domainGameModule)
    viewModelOf(::HighScoreViewModel)
}
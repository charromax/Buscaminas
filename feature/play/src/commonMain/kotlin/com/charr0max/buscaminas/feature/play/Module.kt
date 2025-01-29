package com.charr0max.buscaminas.feature.play

import com.charr0max.buscaminas.domain.game.domainGameModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val playModule = module {
    includes(domainGameModule)
    viewModelOf(::PlayViewModel)
}
package com.example.project.feature.play

import com.example.project.domain.game.domainGameModule
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val playModule = module {
    includes(domainGameModule)
    viewModelOf(::PlayViewModel)
}
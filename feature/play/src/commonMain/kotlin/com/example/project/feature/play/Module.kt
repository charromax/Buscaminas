package com.example.project.feature.play

import com.example.project.domain.game.domainGameModule
import org.koin.dsl.module

val playModule = module {
    includes(domainGameModule)
}
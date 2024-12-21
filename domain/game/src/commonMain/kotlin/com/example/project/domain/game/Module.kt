package com.example.project.domain.game

import com.example.project.data.game.dataGameModule
import com.example.project.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainGameModule = module {
    includes(dataSettingsModule, dataGameModule)
}

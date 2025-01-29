package com.charr0max.buscaminas.domain.game

import com.charr0max.buscaminas.data.game.dataGameModule
import com.charr0max.buscaminas.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainGameModule = module {
    includes(dataSettingsModule, dataGameModule)
}

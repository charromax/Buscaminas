package com.charr0max.buscaminas.settings

import com.charr0max.buscaminas.domain.settings.domainSettingsModule
import com.charr0max.buscaminas.settings.ui.SettingsScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingsModule = module {
    includes(domainSettingsModule)

    viewModelOf(::SettingsScreenViewModel)
}
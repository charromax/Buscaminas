package com.example.project.settings

import com.example.project.domain.settings.domainSettingsModule
import com.example.project.settings.ui.SettingsScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val settingsModule = module {
    includes(domainSettingsModule)

    viewModelOf(::SettingsScreenViewModel)
}
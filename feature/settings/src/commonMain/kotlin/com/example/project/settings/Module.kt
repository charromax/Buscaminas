package com.example.project.settings

import com.example.project.domain.settings.domainSettingsModule
import org.koin.dsl.module

val settingsModule = module {
    includes(domainSettingsModule)
}
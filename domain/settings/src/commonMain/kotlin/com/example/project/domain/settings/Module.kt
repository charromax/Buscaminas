package com.example.project.domain.settings

import com.example.project.data.settings.dataSettingsModule
import org.koin.dsl.module

val domainSettingsModule = module {
    includes(dataSettingsModule)
}
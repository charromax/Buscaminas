package com.example.project.data.settings

import com.example.project.data.core.dataCoreModule
import org.koin.dsl.module

val dataSettingsModule = module {
    includes(dataCoreModule)
}
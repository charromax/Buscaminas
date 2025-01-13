package com.example.project.domain.settings

import com.example.project.data.settings.dataSettingsModule
import com.example.project.domain.settings.usecase.GetUserNameAsFlow
import com.example.project.domain.settings.usecase.UpdateUserName
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainSettingsModule = module {
    includes(dataSettingsModule)

    factoryOf(::GetUserNameAsFlow)
    factoryOf(::UpdateUserName)
}
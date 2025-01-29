package com.charr0max.buscaminas.domain.settings

import com.charr0max.buscaminas.data.settings.dataSettingsModule
import com.charr0max.buscaminas.domain.settings.usecase.GetUserNameAsFlow
import com.charr0max.buscaminas.domain.settings.usecase.UpdateUserName
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainSettingsModule = module {
    includes(dataSettingsModule)

    factoryOf(::GetUserNameAsFlow)
    factoryOf(::UpdateUserName)
}
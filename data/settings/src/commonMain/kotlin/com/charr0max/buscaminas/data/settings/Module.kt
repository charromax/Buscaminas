package com.charr0max.buscaminas.data.settings

import com.charr0max.buscaminas.data.core.dataCoreModule
import com.charr0max.buscaminas.data.settings.repository.DefaultUserNameRepository
import com.charr0max.buscaminas.data.settings.repository.UserNameRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSettingsModule = module {
    includes(dataCoreModule)

    singleOf(::DefaultUserNameRepository) {
        bind<UserNameRepository>()
    }
}
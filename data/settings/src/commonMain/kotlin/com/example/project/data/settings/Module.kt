package com.example.project.data.settings

import com.example.project.data.core.dataCoreModule
import com.example.project.data.settings.repository.DefaultUserNameRepository
import com.example.project.data.settings.repository.UserNameRepository
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataSettingsModule = module {
    includes(dataCoreModule)

    singleOf(::DefaultUserNameRepository) {
        bind<UserNameRepository>()
    }
}
package com.charr0max.buscaminas.data.game

import com.charr0max.buscaminas.data.core.dataCoreModule
import org.koin.dsl.module

val dataGameModule = module {
    includes(dataCoreModule)
}
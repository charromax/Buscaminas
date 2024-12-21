package com.example.project.data.game

import com.example.project.data.core.dataCoreModule
import org.koin.dsl.module

val dataGameModule = module {
    includes(dataCoreModule)
}
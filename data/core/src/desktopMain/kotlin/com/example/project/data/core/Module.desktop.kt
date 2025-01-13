package com.example.project.data.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.project.data.core.storage.createDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single<DataStore<Preferences>> {
        createDataStore()
    }
}
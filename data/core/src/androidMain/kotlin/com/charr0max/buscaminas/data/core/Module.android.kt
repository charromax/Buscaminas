package com.charr0max.buscaminas.data.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.charr0max.buscaminas.data.core.storage.createDataStore
import org.koin.core.module.Module
import org.koin.dsl.module

internal actual val platformModule: Module = module {
    single<DataStore<Preferences>> {
        createDataStore(context = get())
    }
}
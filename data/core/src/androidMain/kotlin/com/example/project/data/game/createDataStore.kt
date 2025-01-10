package com.example.project.data.game

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.project.data.core.storage.createDataStore
import com.example.project.data.core.storage.dataStoreFileName

fun createDataStore(context: Context): DataStore<Preferences> =
    createDataStore(producePath = {
        context.filesDir.resolve(dataStoreFileName).absolutePath
    })
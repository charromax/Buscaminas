package com.example.project.data.game

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.example.project.data.core.storage.createDataStore
import com.example.project.data.core.storage.dataStoreFileName
import java.io.File

fun createDataStore(): DataStore<Preferences> {
    val parentFolder = File(System.getProperty("user.dir"))
    if (!parentFolder.exists()) {
        parentFolder.mkdirs()
    }
    val preferencesPath = File(parentFolder, dataStoreFileName)
    return createDataStore(
        producePath = {
            preferencesPath.absolutePath
        }
    )
}
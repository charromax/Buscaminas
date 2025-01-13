package com.example.project.data.settings.repository

import com.example.project.data.core.storage.Storage
import kotlinx.coroutines.flow.Flow

interface UserNameRepository {
    val userName: Flow<String>
    suspend fun updateUserName(name: String)

    data object UserNameKey: Storage.Key.StringKey("username", "anon")
}
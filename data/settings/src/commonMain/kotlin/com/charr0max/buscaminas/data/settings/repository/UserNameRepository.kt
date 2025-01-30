package com.charr0max.buscaminas.data.settings.repository

import com.charr0max.buscaminas.data.core.storage.Storage
import kotlinx.coroutines.flow.Flow

interface UserNameRepository {
    val userName: Flow<String>
    suspend fun updateUserName(name: String)

    data object UserNameKey: Storage.Key.StringKey("username", "CULENGUE")
}
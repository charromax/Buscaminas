package com.charr0max.buscaminas.data.settings.repository

import com.charr0max.buscaminas.data.core.storage.Storage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultUserNameRepository(
    private val storage: Storage
) : UserNameRepository {
    override val userName: Flow<String>
        get() = storage
            .getAsFlow(UserNameRepository.UserNameKey)
            .map {
                it.orEmpty()
            }

    override suspend fun updateUserName(name: String) {
        storage.write(UserNameRepository.UserNameKey, name)
    }
}
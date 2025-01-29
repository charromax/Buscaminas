package com.charr0max.buscaminas.domain.settings.usecase

import com.charr0max.buscaminas.data.settings.repository.UserNameRepository
import kotlinx.coroutines.flow.Flow

class GetUserNameAsFlow(
    private val userNameRepository: UserNameRepository
) {
    operator fun invoke(): Flow<String> = userNameRepository.userName
}
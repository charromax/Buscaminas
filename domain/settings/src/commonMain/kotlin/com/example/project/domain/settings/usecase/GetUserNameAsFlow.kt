package com.example.project.domain.settings.usecase

import com.example.project.data.settings.repository.UserNameRepository
import kotlinx.coroutines.flow.Flow

class GetUserNameAsFlow(
    private val userNameRepository: UserNameRepository
) {
    operator fun invoke(): Flow<String> = userNameRepository.userName
}
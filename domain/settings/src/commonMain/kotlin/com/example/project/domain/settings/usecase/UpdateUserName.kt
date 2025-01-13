package com.example.project.domain.settings.usecase

import com.example.project.data.settings.repository.UserNameRepository

class UpdateUserName(
    private val userNameRepository: UserNameRepository
) {
    suspend operator fun invoke(name: String) {
        userNameRepository.updateUserName(name)
    }
}
package com.charr0max.buscaminas.domain.settings.usecase

import com.charr0max.buscaminas.data.settings.repository.UserNameRepository

class UpdateUserName(
    private val userNameRepository: UserNameRepository
) {
    suspend operator fun invoke(name: String) {
        userNameRepository.updateUserName(name)
    }
}
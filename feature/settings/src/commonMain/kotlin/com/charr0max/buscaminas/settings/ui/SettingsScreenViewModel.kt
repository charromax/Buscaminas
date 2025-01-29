package com.charr0max.buscaminas.settings.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.charr0max.buscaminas.domain.settings.usecase.GetUserNameAsFlow
import com.charr0max.buscaminas.domain.settings.usecase.UpdateUserName
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class SettingsScreenViewModel(
    private val getUserNameAsFlow: GetUserNameAsFlow,
    private val updateUserName: UpdateUserName
) : ViewModel() {

    // El flujo que expone el username al UI
    val userName: StateFlow<String> = getUserNameAsFlow()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000L),
            "" // Valor inicial del flujo
        )

    fun save(name: String) = viewModelScope.launch {
        updateUserName(name)
    }
}
package com.example.mistplaychallenge.presentation.ui.model

sealed interface UsersUIState {
    data object Loading : UsersUIState
    data class Success(val userList: List<UserUI>) : UsersUIState
    data class Error(val message: String) : UsersUIState
}
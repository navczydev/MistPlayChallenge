package com.example.mistplaychallenge.presentation.ui.model

sealed interface FinalUIState {
    data object Loading : FinalUIState
    data class Success(val data: List<PostUI>) : FinalUIState
    data class Error(val message: String) : FinalUIState
}
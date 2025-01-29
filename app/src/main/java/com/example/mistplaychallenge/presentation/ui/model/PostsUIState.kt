package com.example.mistplaychallenge.presentation.ui.model

sealed interface PostsUIState {
        data object Loading : PostsUIState
        data class Success(val postList: List<PostUI>) : PostsUIState
        data class Error(val message: String) : PostsUIState
}

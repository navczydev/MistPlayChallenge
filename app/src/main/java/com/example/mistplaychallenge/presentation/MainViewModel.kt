package com.example.mistplaychallenge.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mistplaychallenge.domain.usecase.GetPostsUseCase
import com.example.mistplaychallenge.domain.usecase.GetUsersUseCase
import com.example.mistplaychallenge.presentation.ui.mappers.UIPostMapper
import com.example.mistplaychallenge.presentation.ui.mappers.UIUserMapper
import com.example.mistplaychallenge.presentation.ui.model.FinalUIState
import com.example.mistplaychallenge.presentation.ui.model.PostsUIState
import com.example.mistplaychallenge.presentation.ui.model.UsersUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val getUsersUseCase: GetUsersUseCase,
    private val uiPostMapper: UIPostMapper,
    private val uiUserMapper: UIUserMapper
) : ViewModel() {

    private val _posts = MutableStateFlow<PostsUIState>(PostsUIState.Loading)
    val posts = _posts.asStateFlow()

    private val _users = MutableStateFlow<UsersUIState>(UsersUIState.Loading)
    val users = _users.asStateFlow()

    val combinedData: StateFlow<FinalUIState> = _posts.combine(_users) { posts, users ->
        when {
            posts is PostsUIState.Success && users is UsersUIState.Success -> {
                val postList = posts.postList
                val userList = users.userList
                val finalList = postList.map { post ->
                    val user = userList.find { it.id == post.userId }
                    if (user != null) {
                        post.copy(userName = user.name)
                    } else {
                        post
                    }
                }
                FinalUIState.Success(finalList)
            }

            posts is PostsUIState.Error || users is UsersUIState.Error -> {
                FinalUIState.Error("Error fetching posts")
            }

            else -> {
                FinalUIState.Loading
            }

        }
    }.onStart {
        emit(FinalUIState.Loading)
        getUsers()
        getPosts()
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5_000),
        FinalUIState.Loading
    )


    fun getUsers() {
        viewModelScope.launch {
            Timber.d("getUsers called")
            val result = getUsersUseCase()
            Timber.d("getUsersResult: $result")
            _users.value = when (result.isEmpty()) {
                true -> UsersUIState.Error("No users found")
                false -> UsersUIState.Success(result.map { uiUserMapper.mapToView(it) })
            }
        }
    }

    fun getPosts() {
        viewModelScope.launch {
            Timber.d("getPosts called")
            val result = getPostsUseCase()
            Timber.d("getPostsResult: $result")
            _posts.value = when (result.isEmpty()) {
                true -> PostsUIState.Error("No posts found")
                false -> PostsUIState.Success(result.map { uiPostMapper.mapToView(it) })
            }

        }

    }
}
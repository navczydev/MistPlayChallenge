package com.example.mistplaychallenge.presentation

import com.example.mistplaychallenge.ImplFakePostsRepository
import com.example.mistplaychallenge.ImplFakeUsersRepository
import com.example.mistplaychallenge.domain.usecase.GetPostsUseCase
import com.example.mistplaychallenge.domain.usecase.GetUsersUseCase
import com.example.mistplaychallenge.presentation.ui.mappers.UIPostMapper
import com.example.mistplaychallenge.presentation.ui.mappers.UIUserMapper
import com.example.mistplaychallenge.presentation.ui.model.FinalUIState
import com.example.mistplaychallenge.presentation.ui.model.PostsUIState
import com.example.mistplaychallenge.presentation.ui.model.UsersUIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var viewModel: MainViewModel
    private lateinit var getPostsUseCase: GetPostsUseCase
    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var uiPostMapper: UIPostMapper
    private lateinit var uiUserMapper: UIUserMapper
    private lateinit var fakePostsRepository: ImplFakePostsRepository
    private lateinit var fakeUsersRepository: ImplFakeUsersRepository

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = UnconfinedTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        fakePostsRepository = ImplFakePostsRepository()
        fakeUsersRepository = ImplFakeUsersRepository()
        getPostsUseCase = GetPostsUseCase(fakePostsRepository)
        getUsersUseCase = GetUsersUseCase(fakeUsersRepository)
        uiPostMapper = UIPostMapper()
        uiUserMapper = UIUserMapper()
        viewModel = MainViewModel(getPostsUseCase, getUsersUseCase, uiPostMapper, uiUserMapper)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        fakePostsRepository.shouldReturnError = false
        fakeUsersRepository.shouldReturnError = false
    }

    @Test
    fun `when posts use case returns empty list, posts UI state is Error`() = runTest {
        fakePostsRepository.shouldReturnError = true
        viewModel.getPosts()
        assertEquals(PostsUIState.Error("No posts found"), viewModel.posts.value)
    }

    @Test
    fun `when posts use case returns non-empty list, posts UI state is Success`() = runTest {
        viewModel.getPosts()
        assertEquals(1, (viewModel.posts.value as PostsUIState.Success).postList.size)
    }

    @Test
    fun `when users use case returns empty list, users UI state is Error`() = runTest {
        fakeUsersRepository.shouldReturnError = true
        viewModel.getUsers()
        assertEquals(UsersUIState.Error("No users found"), viewModel.users.value)
    }

    @Test
    fun `when users use case returns non-empty list, users UI state is Success`() = runTest {
        viewModel.getUsers()
        assertEquals(1, (viewModel.users.value as UsersUIState.Success).userList.size)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when posts and users use cases return non-empty lists, final UI state is Success`() =
        runTest {
            backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
                viewModel.combinedData.collect {
                }
            }
            assertEquals(1, (viewModel.users.value as UsersUIState.Success).userList.size)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when posts use case returns empty list, final UI state is Error`() = runTest {
        fakePostsRepository.shouldReturnError = true
        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            viewModel.combinedData.collect {
            }
        }
        assertTrue(viewModel.combinedData.value is FinalUIState.Error)
    }


}
package com.example.mistplaychallenge.domain.usecase

import com.example.mistplaychallenge.ImplFakeUsersRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class GetUsersUseCaseTest {
    private lateinit var getUsersUseCase: GetUsersUseCase
    private lateinit var usersRepository: ImplFakeUsersRepository

    @Before
    fun setUp() {
        usersRepository = ImplFakeUsersRepository()
        getUsersUseCase = GetUsersUseCase(usersRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `when usersRepository returns empty list, then getUsers returns empty list`() = runTest {
        usersRepository.shouldReturnError = true
        val result = getUsersUseCase()
        assertTrue(result.isEmpty())
    }

    @Test
    fun `when usersRepository returns non-empty list, then getUsers returns non-empty list`() =
        runTest {
            usersRepository.shouldReturnError = false
            val result = getUsersUseCase()
            assertTrue(result.isNotEmpty())
        }

}
package com.example.mistplaychallenge.domain.usecase

import com.example.mistplaychallenge.domain.model.User
import com.example.mistplaychallenge.domain.repositories.UsersRepository
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(private val usersRepository: UsersRepository) {

    suspend operator fun invoke(): List<User> {
        return usersRepository.getUsers()
    }
}
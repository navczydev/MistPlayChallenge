package com.example.mistplaychallenge.domain.repositories

import com.example.mistplaychallenge.domain.model.User

interface UsersRepository {
    suspend fun getUsers(): List<User>
}
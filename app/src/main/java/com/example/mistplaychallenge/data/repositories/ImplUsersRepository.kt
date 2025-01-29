package com.example.mistplaychallenge.data.repositories

import com.example.mistplaychallenge.data.api.apis.UsersAPI
import com.example.mistplaychallenge.data.api.mappers.APIUserMapper
import com.example.mistplaychallenge.domain.model.User
import com.example.mistplaychallenge.domain.repositories.UsersRepository
import timber.log.Timber
import javax.inject.Inject

class ImplUsersRepository @Inject constructor(
    private val usersAPI: UsersAPI,
    private val userMapper: APIUserMapper
) : UsersRepository {
    override suspend fun getUsers(): List<User> {
        return try {
            val result = usersAPI.getUsers()
            Timber.d("Result: $result")
            result.map { userMapper.mapToDomain(it) }
        } catch (e: Exception) {
            Timber.e("Error getting users: ${e.message}")
            emptyList()
        }
    }
}
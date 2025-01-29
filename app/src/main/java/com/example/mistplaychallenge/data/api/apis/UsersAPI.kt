package com.example.mistplaychallenge.data.api.apis

import com.example.mistplaychallenge.data.api.model.UserDTO
import retrofit2.http.GET

interface UsersAPI {

    @GET("users")
    suspend fun getUsers(): List<UserDTO>
}
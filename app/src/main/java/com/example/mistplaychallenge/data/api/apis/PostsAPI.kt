package com.example.mistplaychallenge.data.api.apis

import com.example.mistplaychallenge.data.api.model.PostDTO
import retrofit2.http.GET

interface PostsAPI {

    @GET("posts")
    suspend fun getPosts(): List<PostDTO>
}
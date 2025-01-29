package com.example.mistplaychallenge.domain.repositories

import com.example.mistplaychallenge.domain.model.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>
}
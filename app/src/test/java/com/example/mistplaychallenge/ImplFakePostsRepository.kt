package com.example.mistplaychallenge

import com.example.mistplaychallenge.domain.model.Post
import com.example.mistplaychallenge.domain.repositories.PostsRepository

class ImplFakePostsRepository : PostsRepository {

    var shouldReturnError = false

    override suspend fun getPosts(): List<Post> {
        return when {
            shouldReturnError -> {
                listOf()
            }

            else -> {
                listOf(
                    Post(
                        userId = 1,
                        id = 1,
                        title = "",
                        body = ""
                    )
                )

            }
        }
    }

}
package com.example.mistplaychallenge.data.repositories

import com.example.mistplaychallenge.data.api.apis.PostsAPI
import com.example.mistplaychallenge.data.api.mappers.APIPostMapper
import com.example.mistplaychallenge.domain.model.Post
import com.example.mistplaychallenge.domain.repositories.PostsRepository
import timber.log.Timber
import javax.inject.Inject

class ImplPostsRepository @Inject constructor(
    private val postsAPI: PostsAPI,
    private val postMapper: APIPostMapper
) : PostsRepository {
    override suspend fun getPosts(): List<Post> {
        return try {
            val result = postsAPI.getPosts()
            Timber.d("Result: $result")
            result.map { postMapper.mapToDomain(it) }
        } catch (e: Exception) {
            Timber.e("Error getting posts: ${e.message}")
            emptyList()
        }
    }
}
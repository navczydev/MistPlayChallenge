package com.example.mistplaychallenge.domain.usecase

import com.example.mistplaychallenge.domain.model.Post
import com.example.mistplaychallenge.domain.repositories.PostsRepository
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(private val postsRepository: PostsRepository) {

    suspend operator fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }

}
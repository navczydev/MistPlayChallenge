package com.example.mistplaychallenge.data.api.mappers

import com.example.mistplaychallenge.data.api.model.PostDTO
import com.example.mistplaychallenge.domain.model.Post
import javax.inject.Inject

class APIPostMapper @Inject constructor() : APIMapper<PostDTO, Post> {
    override fun mapToDomain(entity: PostDTO): Post {
        return Post(
            userId = entity.userId,
            id = entity.id,
            title = entity.title,
            body = entity.body
        )
    }
}
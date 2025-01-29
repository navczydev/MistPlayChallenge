package com.example.mistplaychallenge.presentation.ui.mappers

import com.example.mistplaychallenge.domain.model.Post
import com.example.mistplaychallenge.presentation.ui.model.PostUI
import javax.inject.Inject

class UIPostMapper @Inject constructor() : UIMapper<Post, PostUI> {
    override fun mapToView(input: Post): PostUI {
        return PostUI(
            userId = input.userId,
            userName = "",
            id = input.id,
            title = input.title,
            body = input.body
        )

    }
}
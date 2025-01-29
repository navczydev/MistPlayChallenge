package com.example.mistplaychallenge.presentation.ui.mappers

import com.example.mistplaychallenge.domain.model.User
import com.example.mistplaychallenge.presentation.ui.model.UserUI
import javax.inject.Inject

class UIUserMapper @Inject constructor() : UIMapper<User, UserUI> {
    override fun mapToView(input: User): UserUI {
        return UserUI(
            id = input.id,
            name = input.name,
            username = input.username,
            email = input.email,
            phone = input.phone,
            website = input.website
        )

    }
}
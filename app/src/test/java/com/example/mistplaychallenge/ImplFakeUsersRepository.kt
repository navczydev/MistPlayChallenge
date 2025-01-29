package com.example.mistplaychallenge

import com.example.mistplaychallenge.domain.model.Address
import com.example.mistplaychallenge.domain.model.Company
import com.example.mistplaychallenge.domain.model.User
import com.example.mistplaychallenge.domain.repositories.UsersRepository

class ImplFakeUsersRepository : UsersRepository {

    var shouldReturnError = false

    override suspend fun getUsers(): List<User> {
        return when (shouldReturnError) {
            true -> emptyList()
            false -> listOf(
                User(
                    id = 1,
                    username = "username",
                    name = "name",
                    email = "email",
                    phone = "phone",
                    website = "website",
                    address = Address(
                        street = "street",
                        suite = "suite",
                        city = "city",
                        zipcode = "zipcode",
                        geo = com.example.mistplaychallenge.domain.model.Geo(
                            lat = "lat",
                            lng = "lng"
                        )
                    ),
                    company = Company(
                        name = "name",
                        catchPhrase = "catchPhrase",
                        bs = "bs"
                    )
                )
            )

        }
    }
}
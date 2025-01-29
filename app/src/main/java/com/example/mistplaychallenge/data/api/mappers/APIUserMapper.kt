package com.example.mistplaychallenge.data.api.mappers

import com.example.mistplaychallenge.data.api.model.UserDTO
import com.example.mistplaychallenge.domain.model.User
import javax.inject.Inject

class APIUserMapper @Inject constructor(
    private val addressMapper: APIAddressMapper,
    private val companyMapper: APICompanyMapper
) : APIMapper<UserDTO, User> {
    override fun mapToDomain(entity: UserDTO): User {
        return User(
            id = entity.id,
            name = entity.name,
            email = entity.email,
            username = entity.username,
            address = addressMapper.mapToDomain(entity.address),
            phone = entity.phone,
            website = entity.website,
            company = companyMapper.mapToDomain(entity.company)
        )
    }
}
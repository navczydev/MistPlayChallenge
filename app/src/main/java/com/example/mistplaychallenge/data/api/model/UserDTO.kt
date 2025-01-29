package com.example.mistplaychallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserDTO(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("username") val username: String,
    @SerialName("email") val email: String,
    @SerialName("address") val address: AddressDTO,
    @SerialName("phone") val phone: String,
    @SerialName("website") val website: String,
    @SerialName("company") val company: CompanyDTO
)
package com.example.mistplaychallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompanyDTO(
    @SerialName("name") val name: String,
    @SerialName("catchPhrase") val catchPhrase: String,
    @SerialName("bs") val bs: String
)
package com.example.mistplaychallenge.data.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GeoDTO(
    @SerialName("lat") val lat: String,
    @SerialName("lng") val lng: String
)
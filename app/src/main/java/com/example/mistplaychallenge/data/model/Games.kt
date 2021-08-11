package com.example.mistplaychallenge.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * it maps the games property of [MainModel]'s JSON to this class
 * @author Nav Singh
 */
@Serializable
data class Games(
    @SerialName("title") val title: String,
    @SerialName("img") val img: String
)

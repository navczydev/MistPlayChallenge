package com.example.mistplaychallenge.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * It's Main data class maps JSON to it using serialization library
 * @author Nav Singh
 */
@Serializable
data class MainModel(
    @SerialName("list_title") val listTitle: String,
    @SerialName("games") val games: List<Games>

)

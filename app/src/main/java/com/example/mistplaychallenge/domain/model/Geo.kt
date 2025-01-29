package com.example.mistplaychallenge.domain.model

data class Geo(
    val lat: String,
    val lng: String
) {
    companion object {
        val EMPTY = Geo(
            lat = "",
            lng = ""
        )
    }
}
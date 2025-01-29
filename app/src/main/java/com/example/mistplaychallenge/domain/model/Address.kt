package com.example.mistplaychallenge.domain.model

data class Address(
    val street: String,
    val suite: String,
    val city: String,
    val zipcode: String,
    val geo: Geo
) {
    companion object {
        val EMPTY = Address(
            street = "",
            suite = "",
            city = "",
            zipcode = "",
            geo = Geo.EMPTY
        )
    }
}
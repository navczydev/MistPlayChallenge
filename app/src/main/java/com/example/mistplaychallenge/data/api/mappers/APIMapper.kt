package com.example.mistplaychallenge.data.api.mappers

interface APIMapper<E, D> {
    fun mapToDomain(entity: E): D
}
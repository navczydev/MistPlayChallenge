package com.example.mistplaychallenge.data.api.mappers

import com.example.mistplaychallenge.data.api.model.GeoDTO
import com.example.mistplaychallenge.domain.model.Geo
import javax.inject.Inject

class APIGeoMapper @Inject constructor() : APIMapper<GeoDTO, Geo> {
    override fun mapToDomain(entity: GeoDTO): Geo {
        return Geo(
            lat = entity.lat,
            lng = entity.lng
        )
    }
}
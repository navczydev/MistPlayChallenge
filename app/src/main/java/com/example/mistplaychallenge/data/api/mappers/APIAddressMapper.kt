package com.example.mistplaychallenge.data.api.mappers

import com.example.mistplaychallenge.data.api.model.AddressDTO
import com.example.mistplaychallenge.domain.model.Address
import javax.inject.Inject

class APIAddressMapper @Inject constructor(private val geoMapper: APIGeoMapper) :
    APIMapper<AddressDTO, Address> {
    override fun mapToDomain(entity: AddressDTO): Address {
        return Address(
            street = entity.street,
            suite = entity.suite,
            city = entity.city,
            zipcode = entity.zipcode,
            geo = entity.geo.let { geoMapper.mapToDomain(it) })
    }
}
package com.example.mistplaychallenge.data.api.mappers

import com.example.mistplaychallenge.data.api.model.CompanyDTO
import com.example.mistplaychallenge.domain.model.Company
import javax.inject.Inject

class APICompanyMapper @Inject constructor() : APIMapper<CompanyDTO, Company> {
    override fun mapToDomain(entity: CompanyDTO): Company {
        return Company(
            name = entity.name,
            catchPhrase = entity.catchPhrase,
            bs = entity.bs
        )
    }
}
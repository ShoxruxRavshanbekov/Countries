package uz.futuresoft.countries.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.utils.ResponseResult

interface CountryRepository {

    suspend fun getCountries(): Flow<ResponseResult<List<CountryModel>>>
}
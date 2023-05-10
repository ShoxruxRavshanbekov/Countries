package uz.futuresoft.countries.domain.remote.datasources

import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.utils.ResponseResult

interface CountryDataSource {

    suspend fun allCountries(): Flow<ResponseResult<List<CountryModel>>>
}
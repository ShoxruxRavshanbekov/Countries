package uz.futuresoft.countries.domain.usecases

import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.utils.ResponseResult

interface GetAllCountriesUseCase {
    suspend fun invoke(): Flow<ResponseResult<List<CountryModel>>>
}
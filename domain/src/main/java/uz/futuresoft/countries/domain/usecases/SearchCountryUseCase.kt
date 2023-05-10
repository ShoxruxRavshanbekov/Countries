package uz.futuresoft.countries.domain.usecases

import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.domain.models.CountryModel

interface SearchCountryUseCase {

    suspend fun invoke(data: String): Flow<List<CountryModel>>
}
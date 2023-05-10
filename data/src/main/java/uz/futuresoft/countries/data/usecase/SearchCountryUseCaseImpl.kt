package uz.futuresoft.countries.data.usecase

import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.remote.repositories.CountryRepository
import uz.futuresoft.countries.domain.usecases.SearchCountryUseCase
import javax.inject.Inject

class SearchCountryUseCaseImpl @Inject constructor(
    private val countryRepository: CountryRepository,
) : SearchCountryUseCase {
    override suspend fun invoke(data: String): Flow<List<CountryModel>> {
        return countryRepository.getCountriesByOrder(data = data)
    }
}
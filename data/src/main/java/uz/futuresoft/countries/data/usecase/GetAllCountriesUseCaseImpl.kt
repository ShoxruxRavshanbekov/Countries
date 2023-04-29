package uz.futuresoft.countries.data.usecase

import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.repository.CountryRepository
import uz.futuresoft.countries.domain.usecases.GetAllCountriesUseCase
import uz.futuresoft.countries.domain.utils.ResponseResult
import javax.inject.Inject

class GetAllCountriesUseCaseImpl @Inject constructor(
    private val countryRepository: CountryRepository,
) : GetAllCountriesUseCase {

    override suspend fun invoke(): Flow<ResponseResult<List<CountryModel>>> {
        return countryRepository.getCountries()
    }
}
package uz.futuresoft.countries.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import uz.futuresoft.countries.data.source.network.datasource.CountryDataSourceImpl
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.repository.CountryRepository
import uz.futuresoft.countries.domain.utils.ResponseResult
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryDataSource: CountryDataSourceImpl,
) : CountryRepository {

    override suspend fun getCountries(): Flow<ResponseResult<List<CountryModel>>> {
        return withContext(Dispatchers.IO) {
            countryDataSource.allCountries()
        }
    }
}
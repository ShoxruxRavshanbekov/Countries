package uz.futuresoft.countries.data.remote.repositories

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import uz.futuresoft.countries.domain.local.data_sources.CountryLocalDataSource
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.remote.datasources.CountryDataSource
import uz.futuresoft.countries.domain.remote.repositories.CountryRepository
import uz.futuresoft.countries.domain.utils.ResponseResult
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val countryDataSource: CountryDataSource,
    private val countryLocalDataSource: CountryLocalDataSource,
) : CountryRepository {

    override suspend fun getCountries(): Flow<ResponseResult<List<CountryModel>>> =
        withContext(Dispatchers.IO) {
            flow {
                emit(
                    value = ResponseResult.Success(
                        data = countryLocalDataSource.getAllCountries(),
                        statusCode = 200
                    )
                )

                val response = countryDataSource.allCountries()
                response.collect {
                    when (it) {
                        is ResponseResult.Success -> {
                            countryLocalDataSource.deleteCountries(countries = countryLocalDataSource.getAllCountries())
                            countryLocalDataSource.insertCountries(countries = it.data)
                            emit(ResponseResult.Success(data = it.data, statusCode = it.statusCode))
                        }

                        is ResponseResult.Error -> {
                            emit(value = it)
                        }
                    }
                }
            }
        }

    override suspend fun getCountriesByOrder(data: String): Flow<List<CountryModel>> =
        withContext(Dispatchers.IO) {
            flow {
                val dataByOrder = countryLocalDataSource.getCountriesByOrder(data = data)

                emit(value = dataByOrder)
            }
        }
}
package uz.futuresoft.countries.data.remote.datasources

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.futuresoft.countries.data.remote.apis.CountriesApi
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.remote.datasources.CountryDataSource
import uz.futuresoft.countries.domain.utils.ResponseResult
import javax.inject.Inject

class CountryDataSourceImpl @Inject constructor(
    private val countryApi: CountriesApi,
) : CountryDataSource {

    override suspend fun allCountries(): Flow<ResponseResult<List<CountryModel>>> {
        return flow {
            try {
                val response = countryApi.allCountries()

                if (response.isSuccessful) {
                    val data = response.body()?.map { it.map() } ?: emptyList()
                    val statusCode = response.code()

                    emit(value = ResponseResult.Success(data = data, statusCode = statusCode))
                } else {
                    emit(value = ResponseResult.Error(error = Exception(response.message())))
                }
            } catch (e: Exception) {
                emit(value = ResponseResult.Error(error = Exception(e.message)))
            }
        }
    }
}
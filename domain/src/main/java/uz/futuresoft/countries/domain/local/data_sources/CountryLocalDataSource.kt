package uz.futuresoft.countries.domain.local.data_sources

import uz.futuresoft.countries.domain.models.CountryModel

interface CountryLocalDataSource {

    suspend fun getAllCountries(): List<CountryModel>

    suspend fun getCountriesByOrder(data: String): List<CountryModel>

    suspend fun insertCountries(countries: List<CountryModel>)

    suspend fun updateCountry(country: CountryModel)

    suspend fun deleteCountries(countries: List<CountryModel>)

}
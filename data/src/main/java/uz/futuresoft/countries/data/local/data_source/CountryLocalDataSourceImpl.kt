package uz.futuresoft.countries.data.local.data_source

import uz.futuresoft.countries.data.local.database.daos.CountryDao
import uz.futuresoft.countries.data.local.models.CountryEntity
import uz.futuresoft.countries.domain.local.data_sources.CountryLocalDataSource
import uz.futuresoft.countries.domain.models.CountryModel
import javax.inject.Inject

class CountryLocalDataSourceImpl @Inject constructor(
    private val countryDao: CountryDao,
) : CountryLocalDataSource {

    override suspend fun getAllCountries(): List<CountryModel> {
        return countryDao.getCountries().map { it.map() }
    }

    override suspend fun getCountriesByOrder(data: String): List<CountryModel> {
        return countryDao.getCountriesByOrder(data).map { it.map() }
    }

    override suspend fun insertCountries(countries: List<CountryModel>) {
        countries.forEach { countryDao.insertCountry(CountryEntity(it)) }
    }

    override suspend fun updateCountry(country: CountryModel) {
        countryDao.updateCountry(CountryEntity(country))
    }

    override suspend fun deleteCountries(countries: List<CountryModel>) {
        countries.forEach { countryDao.deleteCountry(CountryEntity(it)) }
    }
}
package uz.futuresoft.countries.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.repository.CountryRepositoryImpl
import uz.futuresoft.countries.domain.repository.CountryRepository

@Module
@InstallIn(SingletonComponent::class)
interface BindRepository {

    @Binds
    fun bindCountryRepository(countryRepositoryImpl: CountryRepositoryImpl): CountryRepository
}
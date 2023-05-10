package uz.futuresoft.countries.data.di.binders

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.remote.repositories.CountryRepositoryImpl
import uz.futuresoft.countries.domain.remote.repositories.CountryRepository

@Module
@InstallIn(SingletonComponent::class)
interface BindRepository {

    @Binds
    fun bindCountryRepository(countryRepositoryImpl: CountryRepositoryImpl): CountryRepository
}
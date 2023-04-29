package uz.futuresoft.countries.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.source.network.datasource.CountryDataSourceImpl
import uz.futuresoft.countries.domain.source.CountryDataSource

@Module
@InstallIn(SingletonComponent::class)
interface BindDataSource {

    @Binds
    fun bindCountryDataSource(countryDataSourceImpl: CountryDataSourceImpl): CountryDataSource
}
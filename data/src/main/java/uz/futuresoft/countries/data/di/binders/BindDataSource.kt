package uz.futuresoft.countries.data.di.binders

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.remote.datasources.CountryDataSourceImpl
import uz.futuresoft.countries.domain.remote.datasources.CountryDataSource

@Module
@InstallIn(SingletonComponent::class)
interface BindDataSource {

    @Binds
    fun bindCountryDataSource(countryDataSourceImpl: CountryDataSourceImpl): CountryDataSource
}
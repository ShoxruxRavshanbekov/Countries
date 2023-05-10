package uz.futuresoft.countries.data.di.binders

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.local.data_source.CountryLocalDataSourceImpl
import uz.futuresoft.countries.domain.local.data_sources.CountryLocalDataSource

@Module
@InstallIn(SingletonComponent::class)
interface BindLocalDataSource {

    @Binds
    fun bindCountryLocalDataSource(countryLocalDataSourceImpl: CountryLocalDataSourceImpl): CountryLocalDataSource
}
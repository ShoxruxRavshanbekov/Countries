package uz.futuresoft.countries.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.futuresoft.countries.data.source.network.api.CountriesApi

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    @Provides
    fun provideCountriesApi(
        retrofit: Retrofit,
    ): CountriesApi = retrofit.create(CountriesApi::class.java)
}
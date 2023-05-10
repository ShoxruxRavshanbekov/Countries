package uz.futuresoft.countries.data.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import uz.futuresoft.countries.data.remote.apis.CountriesApi

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {

    @Provides
    fun provideCountriesApi(
        retrofit: Retrofit,
    ): CountriesApi = retrofit.create(CountriesApi::class.java)
}
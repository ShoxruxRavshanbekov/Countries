package uz.futuresoft.countries.data.di.modules

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.local.database.AppDataBase
import uz.futuresoft.countries.data.local.database.daos.CountryDao

@Module
@InstallIn(SingletonComponent::class)
class DataBaseClientModule {

    @Provides
    fun provideCountryDao(
        appDataBase: AppDataBase,
    ): CountryDao {
        return appDataBase.countryDao()
    }
}
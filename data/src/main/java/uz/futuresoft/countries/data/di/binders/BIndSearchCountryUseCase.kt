package uz.futuresoft.countries.data.di.binders

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.usecase.SearchCountryUseCaseImpl
import uz.futuresoft.countries.domain.usecases.SearchCountryUseCase

@Module
@InstallIn(SingletonComponent::class)
interface BIndSearchCountryUseCase {

    @Binds
    fun bindSearchCountryUseCase(searchCountryUseCaseImpl: SearchCountryUseCaseImpl): SearchCountryUseCase
}
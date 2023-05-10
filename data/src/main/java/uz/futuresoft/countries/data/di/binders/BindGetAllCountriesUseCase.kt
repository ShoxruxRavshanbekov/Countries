package uz.futuresoft.countries.data.di.binders

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.futuresoft.countries.data.usecase.GetAllCountriesUseCaseImpl
import uz.futuresoft.countries.domain.usecases.GetAllCountriesUseCase

@Module
@InstallIn(SingletonComponent::class)
interface BindGetAllCountriesUseCase {

    @Binds
    fun bindGetAllCountriesUseCase(getAllCountriesUseCaseImpl: GetAllCountriesUseCaseImpl): GetAllCountriesUseCase
}
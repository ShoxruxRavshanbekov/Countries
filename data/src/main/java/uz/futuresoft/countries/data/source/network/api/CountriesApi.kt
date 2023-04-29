package uz.futuresoft.countries.data.source.network.api

import retrofit2.Response
import retrofit2.http.GET
import uz.futuresoft.countries.data.source.network.models.Base

interface CountriesApi {

    @GET("v3.1/all")
    suspend fun allCountries(): Response<Base>
}
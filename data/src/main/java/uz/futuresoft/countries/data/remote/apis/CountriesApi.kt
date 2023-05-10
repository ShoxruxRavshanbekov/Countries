package uz.futuresoft.countries.data.remote.apis

import retrofit2.Response
import retrofit2.http.GET
import uz.futuresoft.countries.data.remote.models.Base

interface CountriesApi {

    @GET("v3.1/all")
    suspend fun allCountries(): Response<Base>
}
package uz.futuresoft.countries.domain.models

data class CountryModel(
    val name: String,
    val flag: String,
    val capital: String,
    val population: Int,
    val language: String,
    val currency: String,
    val region: String,
    val subregion: String,
    val timezone: String,
    val start_of_week: String,
    val location: List<Double>,
)

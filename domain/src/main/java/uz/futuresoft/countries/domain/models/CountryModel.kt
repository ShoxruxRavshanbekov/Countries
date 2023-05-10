package uz.futuresoft.countries.domain.models

data class CountryModel(
    val id: Int? = null,
    val common_name: String? = null,
    val official_name: String? = null,
    val flag: String? = null,
    val capital: List<String>,
    val population: Int? = null,
    val region: String? = null,
    val subregion: String? = null,
    val timezone: List<String>,
    val start_of_week: String? = null,
)

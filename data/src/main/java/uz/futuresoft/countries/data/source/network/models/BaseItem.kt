package uz.futuresoft.countries.data.source.network.models

import uz.futuresoft.countries.domain.models.CountryModel

data class BaseItem(
    val altSpellings: List<String>,
    val area: Double,
    val borders: List<String>,
    val capital: List<String>,
    val capitalInfo: CapitalInfo,
    val car: Car,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArms,
    val continents: List<String>,
    val currencies: Currencies,
    val demonyms: Demonyms,
    val fifa: String,
    val flag: String,
    val flags: Flags,
    val gini: Gini,
    val idd: Idd,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: Languages,
    val latlng: List<Double>,
    val maps: Maps,
    val name: Name,
    val population: Int,
    val postalCode: PostalCode,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>,
    val tld: List<String>,
    val translations: Translations,
    val unMember: Boolean,
) {
    fun map(): CountryModel {
        return CountryModel(
            name = name.official,
            flag = flags.png,
            language = languages.toString(),
            capital = capital[0],
            population = population,
            currency = currencies.toString(),
            region = region,
            subregion = subregion,
            timezone = timezones[0],
            start_of_week = startOfWeek,
            location = latlng
        )
    }
}
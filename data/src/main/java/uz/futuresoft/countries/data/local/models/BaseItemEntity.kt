package uz.futuresoft.countries.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.futuresoft.countries.domain.models.CountryModel

@Entity(tableName = "countryFromRemote")
data class BaseItemEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val altSpellings: String,
    val area: Double,
    val borders: String,
    val capital: List<String>?,
    val capitalInfo: CapitalInfoEntity,
    val car: CarEntity,
    val cca2: String,
    val cca3: String,
    val ccn3: String,
    val cioc: String,
    val coatOfArms: CoatOfArmsEntity,
    val continents: String,
    val currencies: CurrenciesEntity,
    val demonyms: DemonymsEntity,
    val fifa: String,
    val flag: String,
    val flags: FlagsEntity,
    val gini: GiniEntity,
    val idd: IddEntity,
    val independent: Boolean,
    val landlocked: Boolean,
    val languages: LanguagesEntity,
    val latlng: String,
    val maps: MapsEntity,
    val name: NameEntity,
    val population: Int,
    val postalCode: PostalCodeEntity,
    val region: String,
    val startOfWeek: String,
    val status: String,
    val subregion: String,
    val timezones: List<String>?,
    val tld: String,
    val translations: TranslationsEntity,
    val unMember: Boolean,
) {

    fun map(): CountryModel {
        return CountryModel(
            common_name = name.common,
            official_name = name.official,
            flag = flags.png,
            capital = capital ?: listOf("not found"),
            population = population,
            region = region,
            subregion = subregion,
            timezone = timezones ?: listOf("not found"),
            start_of_week = startOfWeek,
        )
    }
}
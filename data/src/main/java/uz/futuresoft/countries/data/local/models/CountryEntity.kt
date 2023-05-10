package uz.futuresoft.countries.data.local.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import uz.futuresoft.countries.domain.models.CountryModel

@Entity(tableName = "country")
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
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
) {

    constructor(countryModel: CountryModel) : this(
        id = countryModel.id,
        common_name = countryModel.common_name,
        official_name = countryModel.official_name,
        flag = countryModel.flag,
        capital = countryModel.capital,
        population = countryModel.population,
        region = countryModel.region,
        subregion = countryModel.subregion,
        timezone = countryModel.timezone,
        start_of_week = countryModel.start_of_week,
    )

    fun map(): CountryModel {
        return CountryModel(
            id = id,
            common_name = common_name,
            official_name = official_name,
            flag = flag,
            capital = capital,
            population = population,
            region = region,
            subregion = subregion,
            timezone = timezone,
            start_of_week = start_of_week,
        )
    }

}

package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "name_data")
data class NameDataEntity(
    val common: String,
    val official: String
)
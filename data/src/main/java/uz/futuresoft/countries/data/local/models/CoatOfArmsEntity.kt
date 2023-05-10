package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "coat_of_arms")
data class CoatOfArmsEntity(
    val png: String,
    val svg: String
)
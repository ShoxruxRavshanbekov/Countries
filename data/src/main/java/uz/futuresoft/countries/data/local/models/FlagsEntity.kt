package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "flags")
data class FlagsEntity(
    val alt: String,
    val png: String,
    val svg: String
)
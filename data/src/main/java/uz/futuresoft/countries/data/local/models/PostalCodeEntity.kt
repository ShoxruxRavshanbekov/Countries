package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "postal_code")
data class PostalCodeEntity(
    val format: String,
    val regex: String
)
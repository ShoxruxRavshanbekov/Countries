package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "translation")
data class TranslationEntity(
    val common: String,
    val official: String
)
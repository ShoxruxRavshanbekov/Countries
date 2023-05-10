package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "currency")
data class CurrencyEntity(
    val name: String,
    val symbol: String
)
package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "capital_info")
data class CapitalInfoEntity(
    val latlng: List<Double>
)
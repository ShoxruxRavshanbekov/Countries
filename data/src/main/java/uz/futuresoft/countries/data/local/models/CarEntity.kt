package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "car")
data class CarEntity(
    val side: String,
    val signs: List<String>
)
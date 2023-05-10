package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "maps")
data class MapsEntity(
    val googleMaps: String,
    val openStreetMaps: String
)
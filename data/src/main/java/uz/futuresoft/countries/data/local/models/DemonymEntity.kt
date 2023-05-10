package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "demonym")
data class DemonymEntity(
    val f: String,
    val m: String
)
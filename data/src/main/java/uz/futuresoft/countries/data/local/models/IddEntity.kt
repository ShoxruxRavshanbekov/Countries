package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "idd")
data class IddEntity(
    val root: String,
    val suffixes: List<String>
)
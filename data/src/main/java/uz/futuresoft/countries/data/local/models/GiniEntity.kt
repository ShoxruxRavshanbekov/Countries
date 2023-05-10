package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "gini")
data class GiniEntity(
    val `1999`: Double
)
package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "demonyms")
data class DemonymsEntity(
    val eng: DemonymEntity,
    val fra: DemonymEntity
)
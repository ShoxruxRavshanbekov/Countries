package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "name")
data class NameEntity(
    val common: String,
    val nativeName: NativeNameEntity,
    val official: String
)
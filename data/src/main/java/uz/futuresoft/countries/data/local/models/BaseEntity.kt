package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "base_entity")
class BaseEntity : ArrayList<BaseItemEntity>()
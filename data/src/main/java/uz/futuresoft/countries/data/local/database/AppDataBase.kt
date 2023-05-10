package uz.futuresoft.countries.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import uz.futuresoft.countries.data.local.database.daos.CountryDao
import uz.futuresoft.countries.data.local.database.type_converters.LocalTypeConverterImpl
import uz.futuresoft.countries.data.local.models.CountryEntity

@Database(entities = [CountryEntity::class], version = 1)
@TypeConverters(LocalTypeConverterImpl::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun countryDao(): CountryDao
}
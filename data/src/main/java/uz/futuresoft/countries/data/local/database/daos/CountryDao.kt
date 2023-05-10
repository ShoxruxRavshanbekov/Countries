package uz.futuresoft.countries.data.local.database.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import uz.futuresoft.countries.data.local.models.CountryEntity

@Dao
interface CountryDao {

    @Query("SELECT * FROM country")
    suspend fun getCountries(): List<CountryEntity>

    @Query("SELECT * FROM country WHERE common_name LIKE :data OR official_name LIKE :data")
    suspend fun getCountriesByOrder(data: String): List<CountryEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCountry(country: CountryEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateCountry(country: CountryEntity)

    @Delete
    suspend fun deleteCountry(country: CountryEntity)

}
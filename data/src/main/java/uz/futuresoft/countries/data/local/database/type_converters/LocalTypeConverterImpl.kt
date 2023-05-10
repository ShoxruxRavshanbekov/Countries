package uz.futuresoft.countries.data.local.database.type_converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import uz.futuresoft.countries.domain.local.type_converters.LocalTypeConverter

class LocalTypeConverterImpl : LocalTypeConverter {

    @TypeConverter
    override fun fromStringToList(data: String?): List<String> {
        val temp = data ?: "not found"
        val list = object : TypeToken<List<String>>() {}.type
        return Gson().fromJson(temp, list)
    }

    @TypeConverter
    override fun fromListToString(data: List<String>?): String {
        return Gson().toJson(data)
    }
}
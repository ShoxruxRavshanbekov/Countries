package uz.futuresoft.countries.domain.local.type_converters

interface LocalTypeConverter {

    fun fromStringToList(data: String?): List<String>

    fun fromListToString(data: List<String>?): String
}
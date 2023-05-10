package uz.futuresoft.countries.data.local.models

import androidx.room.Entity

@Entity(tableName = "translations")
data class TranslationsEntity(
    val ara: TranslationEntity,
    val bre: TranslationEntity,
    val ces: TranslationEntity,
    val cym: TranslationEntity,
    val deu: TranslationEntity,
    val est: TranslationEntity,
    val fin: TranslationEntity,
    val fra: TranslationEntity,
    val hrv: TranslationEntity,
    val hun: TranslationEntity,
    val ita: TranslationEntity,
    val jpn: TranslationEntity,
    val kor: TranslationEntity,
    val nld: TranslationEntity,
    val per: TranslationEntity,
    val pol: TranslationEntity,
    val por: TranslationEntity,
    val rus: TranslationEntity,
    val slk: TranslationEntity,
    val spa: TranslationEntity,
    val srp: TranslationEntity,
    val swe: TranslationEntity,
    val tur: TranslationEntity,
    val urd: TranslationEntity,
    val zho: TranslationEntity
)
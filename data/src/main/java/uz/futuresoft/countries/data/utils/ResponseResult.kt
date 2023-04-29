package uz.futuresoft.countries.data.utils

sealed interface ResponseResult<out T> {
    data class Success<T>(val data: T, val statusCode: Int) : ResponseResult<T>
    data class Error(val error: Throwable) : ResponseResult<Nothing>
}

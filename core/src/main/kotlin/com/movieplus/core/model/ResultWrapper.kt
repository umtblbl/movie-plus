package com.movieplus.core.model

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    object NetworkError : ResultWrapper<Nothing>()
    data class GenericError(
        val code: Int? = null,
        val error: ServerErrorResponse? = null
    ) : ResultWrapper<Nothing>()
}

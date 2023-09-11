package com.movieplus.core.extension

import com.movieplus.core.model.ServerErrorResponse
import com.squareup.moshi.Moshi
import retrofit2.HttpException


fun HttpException.convertErrorBody(): ServerErrorResponse? {
    return try {
        this.response()?.errorBody()?.source()?.let {
            val moshiAdapter = Moshi.Builder().build().adapter(ServerErrorResponse::class.java)
            moshiAdapter.fromJson(it)
        }
    } catch (exception: Exception) {
        null
    }
}

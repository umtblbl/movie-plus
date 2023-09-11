package com.movieplus.core.data.remote.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieGenresResponse(
    val genres: List<Genre>?,
)

data class Genre(
    val id: Long?,
    val name: String?,
)

package com.movieplus.core.data.remote.api.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MovieGenreResponse(
    val genres: List<Genre>?,
)

data class Genre(
    val id: Long?,
    val name: String?,
)

package com.movieplus.core.data.remote.api.dataSource

import com.movieplus.core.data.remote.api.TmdbAPI
import com.movieplus.core.domain.BaseRemoteDataSource
import javax.inject.Inject

class TmdbRemoteDataSource @Inject constructor(
    private val tmdbAPI: TmdbAPI
): BaseRemoteDataSource {

    suspend fun movieGenres() = safeApiCall { tmdbAPI.movieGenres() }

    suspend fun popularMovies(
        page: Int?
    ) = safeApiCall { tmdbAPI.popularMovies(page = page) }

    suspend fun topRated(
        page: Int?
    ) = safeApiCall { tmdbAPI.topRated(page = page) }
}

package com.movieplus.core.data.remote.api.dataSource

import com.movieplus.core.data.remote.api.TmdbAPI
import com.movieplus.core.data.remote.api.model.MovieGenreResponse
import com.movieplus.core.data.remote.api.model.PopularMovieResponse
import javax.inject.Inject

class TmdbRemoteDataSource @Inject constructor(
    private val tmdbAPI: TmdbAPI
) {
    suspend fun popularMovies(
        page: Int?
    ) = tmdbAPI.popularMovies(page = page)

    suspend fun movieGenres() = tmdbAPI.movieGenres()
}

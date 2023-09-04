package com.movieplus.core.data.remote.api

import com.movieplus.core.data.remote.api.model.MovieGenreResponse
import com.movieplus.core.data.remote.api.model.PopularMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {

    @GET("genre/movie/list")
    suspend fun movieGenres(): MovieGenreResponse?

    @GET("movie/popular")
    suspend fun popularMovies(
        @Query("page") page: Int?
    ): PopularMovieResponse?
}

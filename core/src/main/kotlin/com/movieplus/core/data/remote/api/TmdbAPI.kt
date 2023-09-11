package com.movieplus.core.data.remote.api

import com.movieplus.core.data.remote.api.model.MovieGenresResponse
import com.movieplus.core.data.remote.api.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbAPI {

    @GET("genre/movie/list")
    suspend fun movieGenres(): MovieGenresResponse?

    @GET("movie/popular")
    suspend fun popularMovies(
        @Query("page") page: Int?
    ): MovieResponse?

    @GET("movie/top_rated")
    suspend fun topRated(
        @Query("page") page: Int?
    ): MovieResponse?
}

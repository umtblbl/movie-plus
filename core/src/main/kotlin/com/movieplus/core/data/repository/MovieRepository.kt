package com.movieplus.core.data.repository

import com.movieplus.core.data.local.room.dataSource.TmdbLocalDataSource
import com.movieplus.core.data.local.room.model.MovieGenreEntity
import com.movieplus.core.data.local.room.model.PopularMovieEntity
import com.movieplus.core.data.remote.api.dataSource.TmdbRemoteDataSource
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val tmdbLocalDataSource: TmdbLocalDataSource,
    private val tmdbRemoteDataSource: TmdbRemoteDataSource
) {
    suspend fun getMovieGenres() = tmdbRemoteDataSource.movieGenres()

    suspend fun getPopularMovies(
        page: Int?
    ) = tmdbRemoteDataSource.popularMovies(page = page)

    /**
     * If the number of data added is equal to the number returned,
     * it has been added successfully.
     */
    suspend fun addMovieGenre(
        list: List<MovieGenreEntity>
    ) = tmdbLocalDataSource.addMovieGenre(list).size == list.size

    /**
     * If the number of data added is equal to the number returned,
     * it has been added successfully.
     */
    suspend fun addPopularMovie(
        list: List<PopularMovieEntity>
    ) = tmdbLocalDataSource.addPopularMovie(list).size == list.size

    suspend fun getMovieGenreEntities() = tmdbLocalDataSource.getAllMovieGenres()

    suspend fun getPopularMovieEntities() = tmdbLocalDataSource.getAllPopularMovies()

    suspend fun searchMovieGenre(
        id: String
    ) = tmdbLocalDataSource.searchMovieGenre(id)
}

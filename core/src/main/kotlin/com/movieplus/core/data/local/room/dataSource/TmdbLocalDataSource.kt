package com.movieplus.core.data.local.room.dataSource

import com.movieplus.core.data.local.room.dao.MovieGenresDao
import com.movieplus.core.data.local.room.dao.PopularMoviesDao
import com.movieplus.core.data.local.room.model.MovieGenreEntity
import com.movieplus.core.data.local.room.model.PopularMovieEntity
import javax.inject.Inject

class TmdbLocalDataSource @Inject constructor(
    private val movieGenresDao: MovieGenresDao,
    private val popularMoviesDao: PopularMoviesDao
) {
    fun getAllMovieGenres() = movieGenresDao.getAll()

    fun getAllPopularMovies() = popularMoviesDao.getAll()

    fun addMovieGenre(
        entities: List<MovieGenreEntity>
    ) = movieGenresDao.add(*entities.toTypedArray())

    fun searchMovieGenre(
        id: String
    ) = movieGenresDao.search("%$id%")

    fun addPopularMovie(
        entities: List<PopularMovieEntity>
    ) = popularMoviesDao.add(*entities.toTypedArray())
}

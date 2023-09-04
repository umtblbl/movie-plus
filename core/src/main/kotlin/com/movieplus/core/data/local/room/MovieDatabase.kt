package com.movieplus.core.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.movieplus.core.Configs
import com.movieplus.core.data.local.room.dao.MovieGenresDao
import com.movieplus.core.data.local.room.dao.PopularMoviesDao
import com.movieplus.core.data.local.room.model.MovieGenreEntity
import com.movieplus.core.data.local.room.model.PopularMovieEntity


@Database(
    entities = [
        PopularMovieEntity::class,
        MovieGenreEntity::class
    ],
    version = Configs.Database.VERSION,
    exportSchema = Configs.Database.EXPORT_SCHEME
)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun popularMoviesDao(): PopularMoviesDao
    abstract fun movieGenresDao(): MovieGenresDao
}

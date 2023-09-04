package com.movieplus.core.di.module

import android.content.Context
import androidx.room.Room
import com.movieplus.core.Configs
import com.movieplus.core.data.local.room.MovieDatabase
import com.movieplus.core.data.local.room.dao.MovieGenresDao
import com.movieplus.core.data.local.room.dao.PopularMoviesDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): MovieDatabase =
        Room.databaseBuilder(
            context,
            MovieDatabase::class.java,
            Configs.Database.NAME
        ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideMovieGenresDao(
        database: MovieDatabase
    ): MovieGenresDao = database.movieGenresDao()

    @Provides
    fun providePopularMoviesDao(
        database: MovieDatabase
    ): PopularMoviesDao = database.popularMoviesDao()
}

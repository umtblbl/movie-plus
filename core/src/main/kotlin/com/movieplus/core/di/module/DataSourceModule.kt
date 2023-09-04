package com.movieplus.core.di.module

import com.movieplus.core.data.local.room.dao.MovieGenresDao
import com.movieplus.core.data.local.room.dao.PopularMoviesDao
import com.movieplus.core.data.local.room.dataSource.TmdbLocalDataSource
import com.movieplus.core.data.remote.api.TmdbAPI
import com.movieplus.core.data.remote.api.dataSource.TmdbRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataSourceModule {

    @Singleton
    @Provides
    fun provideTmdbRemoteDataSource(
        tmdbAPI: TmdbAPI
    ): TmdbRemoteDataSource = TmdbRemoteDataSource(tmdbAPI)

    @Singleton
    @Provides
    fun provideTmdbLocalDataSource(
        popularMoviesDao: PopularMoviesDao,
        movieGenresDao: MovieGenresDao
    ): TmdbLocalDataSource = TmdbLocalDataSource(
        popularMoviesDao = popularMoviesDao,
        movieGenresDao = movieGenresDao
    )
}

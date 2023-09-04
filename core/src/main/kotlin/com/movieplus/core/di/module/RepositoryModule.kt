package com.movieplus.core.di.module

import com.movieplus.core.data.local.room.dataSource.TmdbLocalDataSource
import com.movieplus.core.data.remote.api.dataSource.TmdbRemoteDataSource
import com.movieplus.core.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        tmdbLocalDataSource: TmdbLocalDataSource,
        tmdbRemoteDataSource: TmdbRemoteDataSource
    ): MovieRepository = MovieRepository(
        tmdbLocalDataSource = tmdbLocalDataSource,
        tmdbRemoteDataSource = tmdbRemoteDataSource
    )
}

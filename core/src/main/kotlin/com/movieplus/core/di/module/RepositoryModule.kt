package com.movieplus.core.di.module

import com.movieplus.core.data.local.room.dataSource.TmdbLocalDataSource
import com.movieplus.core.data.mediator.PopularMovieRemoteMediator
import com.movieplus.core.data.mediator.TopRatedRemoteMediator
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
        tmdbRemoteDataSource: TmdbRemoteDataSource,
        popularMovieRemoteMediator: PopularMovieRemoteMediator,
        topRatedRemoteMediator: TopRatedRemoteMediator
    ): MovieRepository = MovieRepository(
        tmdbLocalDataSource = tmdbLocalDataSource,
        tmdbRemoteDataSource = tmdbRemoteDataSource,
        popularMovieRemoteMediator = popularMovieRemoteMediator,
        topRatedRemoteMediator =  topRatedRemoteMediator
    )
}

package com.movieplus.core.di.module

import com.movieplus.core.data.mediator.PopularMovieRemoteMediator
import com.movieplus.core.data.mediator.TopRatedRemoteMediator
import com.movieplus.core.data.remote.api.dataSource.TmdbRemoteDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MediatorModule {

    @Singleton
    @Provides
    fun providePopularMovieRemoteMediator(
        tmdbRemoteDataSource: TmdbRemoteDataSource
    ): PopularMovieRemoteMediator = PopularMovieRemoteMediator(
        tmdbRemoteDataSource = tmdbRemoteDataSource,
    )

    @Singleton
    @Provides
    fun provideTopRatedRemoteMediator(
        tmdbRemoteDataSource: TmdbRemoteDataSource
    ): TopRatedRemoteMediator = TopRatedRemoteMediator(
        tmdbRemoteDataSource = tmdbRemoteDataSource,
    )
}

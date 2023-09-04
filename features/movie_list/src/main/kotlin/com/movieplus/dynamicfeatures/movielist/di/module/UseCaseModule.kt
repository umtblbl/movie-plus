package com.movieplus.dynamicfeatures.movielist.di.module

import com.movieplus.core.data.repository.MovieRepository
import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.movielist.domain.PopularMovieUseCase
import com.movieplus.dynamicfeatures.movielist.mapper.PopularMovieResponseMapper
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @FeatureScope
    @Provides
    fun providePopularMovieUseCase(
        movieRepository: MovieRepository,
        popularMovieResponseMapper: PopularMovieResponseMapper
    ) = PopularMovieUseCase(
        movieRepository = movieRepository,
        popularMovieResponseMapper = popularMovieResponseMapper
    )
}

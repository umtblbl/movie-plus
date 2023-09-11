package com.movieplus.dynamicfeatures.movielist.di.module

import com.movieplus.core.data.repository.MovieRepository
import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.movielist.domain.MovieGenresUseCase
import com.movieplus.dynamicfeatures.movielist.domain.PopularMovieUseCase
import com.movieplus.dynamicfeatures.movielist.domain.TopRatedUseCase
import com.movieplus.dynamicfeatures.movielist.mapper.MovieGenresMapper
import com.movieplus.dynamicfeatures.movielist.mapper.MovieResponseMapper
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @FeatureScope
    @Provides
    fun providePopularMovieUseCase(
        movieRepository: MovieRepository,
        movieResponseMapper: MovieResponseMapper
    ) = PopularMovieUseCase(
        movieRepository = movieRepository,
        movieResponseMapper = movieResponseMapper
    )

    @FeatureScope
    @Provides
    fun provideTopRatedUseCase(
        movieRepository: MovieRepository,
        movieResponseMapper: MovieResponseMapper
    ) = TopRatedUseCase(
        movieRepository = movieRepository,
        movieResponseMapper = movieResponseMapper
    )

    @FeatureScope
    @Provides
    fun provideMovieGenresUseCase(
        movieRepository: MovieRepository,
        movieGenresMapper: MovieGenresMapper
    ) = MovieGenresUseCase(
        movieRepository = movieRepository,
        movieGenresMapper = movieGenresMapper
    )
}

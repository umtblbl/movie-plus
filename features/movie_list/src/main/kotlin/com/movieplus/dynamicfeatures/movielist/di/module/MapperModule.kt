package com.movieplus.dynamicfeatures.movielist.di.module

import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.movielist.mapper.MovieGenresMapper
import com.movieplus.dynamicfeatures.movielist.mapper.MovieResponseMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @FeatureScope
    @Provides
    fun provideMovieResponseMapper() = MovieResponseMapper()

    @FeatureScope
    @Provides
    fun provideMovieGenresResponseMapper() = MovieGenresMapper()
}

package com.movieplus.dynamicfeatures.movielist.di.module

import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.movielist.mapper.PopularMovieResponseMapper
import dagger.Module
import dagger.Provides

@Module
class MapperModule {

    @FeatureScope
    @Provides
    fun providePopularMovieResponseMapper() = PopularMovieResponseMapper()
}

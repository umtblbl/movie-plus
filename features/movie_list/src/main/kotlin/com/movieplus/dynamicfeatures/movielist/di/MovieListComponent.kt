package com.movieplus.dynamicfeatures.movielist.di

import com.movieplus.core.di.CoreComponent
import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.movielist.di.module.MapperModule
import com.movieplus.dynamicfeatures.movielist.di.module.MovieListModule
import com.movieplus.dynamicfeatures.movielist.di.module.UseCaseModule
import com.movieplus.dynamicfeatures.movielist.ui.MovieListFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        MovieListModule::class,
        UseCaseModule::class,
        MapperModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface MovieListComponent {
    fun inject(movieListFragment: MovieListFragment)
}

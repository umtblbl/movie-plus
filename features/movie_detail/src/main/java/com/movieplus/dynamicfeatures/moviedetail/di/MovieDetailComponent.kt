package com.movieplus.dynamicfeatures.moviedetail.di

import com.movieplus.core.di.CoreComponent
import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.moviedetail.di.module.MovieDetailModule
import com.movieplus.dynamicfeatures.moviedetail.ui.MovieDetailFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        MovieDetailModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface MovieDetailComponent {
    fun inject(movieDetailFragment: MovieDetailFragment)
}

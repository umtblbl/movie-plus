package com.movieplus.dynamicfeatures.movieplayer.di

import com.movieplus.core.di.CoreComponent
import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.movieplayer.di.module.MoviePlayerModule
import com.movieplus.dynamicfeatures.movieplayer.ui.MoviePlayerFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [
        MoviePlayerModule::class
    ],
    dependencies = [CoreComponent::class]
)
interface MoviePlayerComponent {
    fun inject(moviePlayerFragment: MoviePlayerFragment)
}

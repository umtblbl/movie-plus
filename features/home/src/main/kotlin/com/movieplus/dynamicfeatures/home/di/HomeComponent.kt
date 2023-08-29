package com.movieplus.dynamicfeatures.home.di

import com.movieplus.core.di.CoreComponent
import com.movieplus.core.di.scope.FeatureScope
import com.movieplus.dynamicfeatures.home.di.module.HomeModule
import com.movieplus.dynamicfeatures.home.ui.HomeFragment
import dagger.Component

@FeatureScope
@Component(
    modules = [HomeModule::class],
    dependencies = [CoreComponent::class]
)
interface HomeComponent {
    fun inject(homeFragment: HomeFragment)
}

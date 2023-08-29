package com.movieplus.dynamicfeatures.moviedetail.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieplus.commons.di.ViewModelFactory
import com.movieplus.commons.di.ViewModelKey
import com.movieplus.dynamicfeatures.moviedetail.ui.MovieDetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieDetailModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MovieDetailViewModel::class)
    abstract fun provideUserDetailViewModel(userFavoritesViewModel: MovieDetailViewModel): ViewModel
}

package com.movieplus.dynamicfeatures.movielist.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieplus.commons.di.ViewModelFactory
import com.movieplus.commons.di.ViewModelKey
import com.movieplus.dynamicfeatures.movielist.ui.MovieListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MovieListModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MovieListViewModel::class)
    abstract fun provideUserSearchViewModel(movieListViewModel: MovieListViewModel): ViewModel
}

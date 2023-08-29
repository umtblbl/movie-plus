package com.movieplus.dynamicfeatures.movieplayer.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movieplus.dynamicfeatures.movieplayer.ui.MoviePlayerViewModel
import com.movieplus.commons.di.ViewModelFactory
import com.movieplus.commons.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MoviePlayerModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @IntoMap
    @Binds
    @ViewModelKey(MoviePlayerViewModel::class)
    abstract fun provideUserFavoritesViewModel(moviePlayerViewModel: MoviePlayerViewModel): ViewModel
}

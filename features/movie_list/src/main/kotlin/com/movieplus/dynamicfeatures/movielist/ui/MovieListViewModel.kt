package com.movieplus.dynamicfeatures.movielist.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.movieplus.dynamicfeatures.movielist.domain.PopularMovieUseCase
import com.movieplus.dynamicfeatures.movielist.model.PopularMovie
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val popularMovieUseCase: PopularMovieUseCase
) : ViewModel() {

    val popularMovieData = MutableLiveData<PopularMovie>()

    suspend fun popularMovie() {
        popularMovieUseCase()
        popularMovieData.postValue(
            popularMovieUseCase()
        )
    }
}

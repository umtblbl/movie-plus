package com.movieplus.dynamicfeatures.movielist.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.movieplus.core.model.ResultWrapper
import com.movieplus.core.util.MediatorLoadType
import com.movieplus.dynamicfeatures.movielist.domain.MovieGenresUseCase
import com.movieplus.dynamicfeatures.movielist.domain.PopularMovieUseCase
import com.movieplus.dynamicfeatures.movielist.domain.TopRatedUseCase
import com.movieplus.dynamicfeatures.movielist.model.MovieGenre
import com.movieplus.dynamicfeatures.movielist.model.MovieModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieListViewModel @Inject constructor(
    private val popularMovieUseCase: PopularMovieUseCase,
    private val topRatedUseCase: TopRatedUseCase,
    private val movieGenresUseCase: MovieGenresUseCase
) : ViewModel() {

    val topRatedData: LiveData<List<MovieModel>?>
        get() = _topRatedData
    private val _topRatedData = MutableLiveData<List<MovieModel>?>()

    val popularMovieData: LiveData<List<MovieModel>?>
        get() = _popularMovieData
    private val _popularMovieData = MutableLiveData<List<MovieModel>?>()

    val movieGenresData: LiveData<List<MovieGenre>?>
        get() = _movieGenresData
    private val _movieGenresData = MutableLiveData<List<MovieGenre>?>()

    val errorResponse: LiveData<String?>
        get() = _errorResponse
    private val _errorResponse = MutableLiveData<String?>()

    suspend fun movieGenres() {
        withContext(Dispatchers.IO) {
            movieGenresUseCase().let { result ->
                when (result) {
                    is ResultWrapper.Success ->
                        _movieGenresData.postValue(result.value)
                    is ResultWrapper.NetworkError ->
                        _errorResponse.postValue(null)
                    is ResultWrapper.GenericError ->
                        _errorResponse.postValue(result.error?.title)
                }
            }
        }
    }

    suspend fun popularMovie(loadType: MediatorLoadType) {
        withContext(Dispatchers.IO) {
            popularMovieUseCase(
                PopularMovieUseCase.Params(
                    mediatorLoadType = loadType
                )
            ).let { result ->
                when (result) {
                    is ResultWrapper.Success ->
                        _popularMovieData.postValue(result.value)
                    is ResultWrapper.NetworkError ->
                        _errorResponse.postValue(null)
                    is ResultWrapper.GenericError ->
                        _errorResponse.postValue(result.error?.title)
                }
            }
        }
    }

    suspend fun topRated(loadType: MediatorLoadType) {
        withContext(Dispatchers.IO) {
            topRatedUseCase(
                TopRatedUseCase.Params(
                    mediatorLoadType = loadType
                )
            ).let { result ->
                when (result) {
                    is ResultWrapper.Success ->
                        _topRatedData.postValue(result.value)
                    is ResultWrapper.NetworkError ->
                        _errorResponse.postValue(null)
                    is ResultWrapper.GenericError ->
                        _errorResponse.postValue(result.error?.title)
                }
            }
        }
    }
}

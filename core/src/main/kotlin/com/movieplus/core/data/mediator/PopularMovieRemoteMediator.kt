package com.movieplus.core.data.mediator

import com.movieplus.core.data.remote.api.dataSource.TmdbRemoteDataSource
import com.movieplus.core.data.remote.api.model.PopularMovieData
import com.movieplus.core.data.remote.api.model.MovieResponse
import com.movieplus.core.model.ResultWrapper
import com.movieplus.core.util.MediatorLoadType
import javax.inject.Inject

class PopularMovieRemoteMediator @Inject constructor(
    private val tmdbRemoteDataSource: TmdbRemoteDataSource
) {

    private var nextPage = 1
    private var list = mutableListOf<PopularMovieData?>()

    suspend fun load(
        mediatorLoadType: MediatorLoadType?
    ): ResultWrapper<List<PopularMovieData?>> {
        when (mediatorLoadType ?: MediatorLoadType.Initial) {
            MediatorLoadType.Initial -> {
                nextPage = 1
                list = mutableListOf()
            }
            MediatorLoadType.Load -> {}
        }
        val response = data()
        if (response is ResultWrapper.Success) {
            response.value?.popularMovies?.filterNotNull()?.let {
                list.addAll(it)
            }
            nextPage += (response.value?.page ?: 0) + 1
            return ResultWrapper.Success(list)
        }
        return ResultWrapper.GenericError()
    }

    private suspend fun data(): ResultWrapper<MovieResponse?> {
        return tmdbRemoteDataSource.popularMovies(
            page = nextPage
        )
    }
}

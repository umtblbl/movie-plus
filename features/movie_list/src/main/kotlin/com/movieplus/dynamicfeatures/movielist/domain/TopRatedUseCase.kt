package com.movieplus.dynamicfeatures.movielist.domain

import com.movieplus.core.data.repository.MovieRepository
import com.movieplus.core.domain.UseCase
import com.movieplus.core.model.ResultWrapper
import com.movieplus.core.util.MediatorLoadType
import com.movieplus.dynamicfeatures.movielist.mapper.MovieResponseMapper
import com.movieplus.dynamicfeatures.movielist.model.MovieModel
import javax.inject.Inject

class TopRatedUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieResponseMapper: MovieResponseMapper
) : UseCase<ResultWrapper<List<MovieModel>?>, TopRatedUseCase.Params>() {

    data class Params(val mediatorLoadType: MediatorLoadType?)

    override suspend fun invoke(
        params: Params?
    ): ResultWrapper<List<MovieModel>?> {
        movieRepository.getTopRated(loadType = params?.mediatorLoadType).let { response ->
            return when (response) {
                is ResultWrapper.Success -> ResultWrapper.Success(
                    movieResponseMapper.map(response.value)
                )
                is ResultWrapper.GenericError -> ResultWrapper.GenericError(
                    response.code,
                    response.error
                )
                is ResultWrapper.NetworkError -> ResultWrapper.NetworkError
            }
        }
    }
}

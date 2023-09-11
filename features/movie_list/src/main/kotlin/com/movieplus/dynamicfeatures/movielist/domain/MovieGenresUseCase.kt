package com.movieplus.dynamicfeatures.movielist.domain

import com.movieplus.core.data.repository.MovieRepository
import com.movieplus.core.domain.UseCase
import com.movieplus.core.model.ResultWrapper
import com.movieplus.dynamicfeatures.movielist.mapper.MovieGenresMapper
import com.movieplus.dynamicfeatures.movielist.model.MovieGenre
import javax.inject.Inject

class MovieGenresUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val movieGenresMapper: MovieGenresMapper
) : UseCase<ResultWrapper<List<MovieGenre>?>, UseCase.None>() {

    override suspend fun invoke(
        params: None?
    ): ResultWrapper<List<MovieGenre>?> {
        movieRepository.getMovieGenres().let { response ->
            return when (response) {
                is ResultWrapper.Success -> ResultWrapper.Success(
                    movieGenresMapper.map(response.value)
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

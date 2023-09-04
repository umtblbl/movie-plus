package com.movieplus.dynamicfeatures.movielist.domain

import com.movieplus.core.data.repository.MovieRepository
import com.movieplus.core.domain.UseCase
import com.movieplus.dynamicfeatures.movielist.mapper.PopularMovieResponseMapper
import com.movieplus.dynamicfeatures.movielist.model.PopularMovie
import javax.inject.Inject

class PopularMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    private val popularMovieResponseMapper: PopularMovieResponseMapper
) : UseCase<PopularMovie?, PopularMovieUseCase.Params>() {

    data class Params(val userName: String?)

    override suspend fun invoke(
        params: Params?
    ) = popularMovieResponseMapper.map(
        movieRepository.getPopularMovies(page = 1)
    )
}

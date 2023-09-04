package com.movieplus.dynamicfeatures.movielist.mapper

import com.movieplus.core.data.remote.api.model.PopularMovieResponse
import com.movieplus.core.mapper.Mapper
import com.movieplus.dynamicfeatures.movielist.model.PopularMovie
import com.movieplus.dynamicfeatures.movielist.model.PopularMovieData

class PopularMovieResponseMapper : Mapper<PopularMovieResponse?, PopularMovie> {
    override fun map(from: PopularMovieResponse?): PopularMovie {
        return PopularMovie(
            page = from?.page ?: 0,
            popularMovies = from?.popularMovies?.map {
                PopularMovieData(
                    genreIds = it?.genreIds ?: listOf(),
                    title = it?.title ?: "",
                    overview = it?.overview ?: "",
                    voteAverage = it?.voteAverage ?: 0.0,
                    posterPath = it?.posterPath ?: "",
                    releaseDate = it?.releaseDate ?: ""
                )
            } ?: listOf(),
            totalPages = from?.totalPages ?: 0,
            totalResults = from?.totalResults ?: 0
        )
    }
}

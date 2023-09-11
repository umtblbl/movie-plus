package com.movieplus.dynamicfeatures.movielist.mapper

import com.movieplus.core.data.remote.api.model.PopularMovieData
import com.movieplus.core.mapper.Mapper
import com.movieplus.dynamicfeatures.movielist.model.MovieModel

class MovieResponseMapper : Mapper<List<PopularMovieData?>, List<MovieModel>> {
    override fun map(from: List<PopularMovieData?>): List<MovieModel> {
        val list = mutableListOf<MovieModel>()
        from.iterator().asSequence().toList()
            .forEach {
                list.add(
                    MovieModel(
                        genreIds = it?.genreIds ?: listOf(),
                        title = it?.title ?: "",
                        overview = it?.overview ?: "",
                        voteAverage = it?.voteAverage ?: 0.0,
                        posterPath = it?.posterPath ?: "",
                        releaseDate = it?.releaseDate ?: ""
                    )
                )
            }
        return list
    }
}

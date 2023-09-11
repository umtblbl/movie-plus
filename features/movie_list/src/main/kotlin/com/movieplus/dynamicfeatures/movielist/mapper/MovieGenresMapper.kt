package com.movieplus.dynamicfeatures.movielist.mapper

import com.movieplus.core.data.remote.api.model.MovieGenresResponse
import com.movieplus.core.mapper.Mapper
import com.movieplus.dynamicfeatures.movielist.model.MovieGenre

class MovieGenresMapper : Mapper<MovieGenresResponse?, List<MovieGenre>> {
    override fun map(from: MovieGenresResponse?): List<MovieGenre> {
        return from?.genres?.map {
            MovieGenre(
                id = it.id,
                name = it.name
            )
        } ?: listOf()
    }
}

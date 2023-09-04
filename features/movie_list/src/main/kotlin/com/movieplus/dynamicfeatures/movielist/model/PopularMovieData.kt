package com.movieplus.dynamicfeatures.movielist.model

class PopularMovie(
    var page: Int,
    var popularMovies: List<PopularMovieData>,
    var totalPages: Int,
    var totalResults: Int
)

class PopularMovieData(
    var genreIds: List<Int>,
    var title: String,
    var overview: String,
    var voteAverage: Double,
    var posterPath: String,
    var releaseDate: String
)

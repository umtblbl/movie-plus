package com.movieplus.core.data.local.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "popular_movie")
data class PopularMovieEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "title") val title: String = "",
    @ColumnInfo(name = "genre_ids") val genreIds: String = "",
    @ColumnInfo(name = "overview") val overview: String = "",
    @ColumnInfo(name = "vote_average") val voteAverage: String = "",
    @ColumnInfo(name = "poster_path") val posterPath: String = "",
    @ColumnInfo(name = "release_date") val releaseDate: String = "",
)

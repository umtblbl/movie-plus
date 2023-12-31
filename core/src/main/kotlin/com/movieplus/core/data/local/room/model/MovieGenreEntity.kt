package com.movieplus.core.data.local.room.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_genres")
data class MovieGenreEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: String = "",
    @ColumnInfo(name = "name") val name: String = "",
)

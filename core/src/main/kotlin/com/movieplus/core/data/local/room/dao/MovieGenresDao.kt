package com.movieplus.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movieplus.core.data.local.room.model.MovieGenreEntity

@Dao
interface MovieGenresDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg entity: MovieGenreEntity): LongArray

    @Query("SELECT * FROM movie_genres WHERE id LIKE :id")
    fun search(id: String?): List<MovieGenreEntity>

    @Query("SELECT * FROM movie_genres")
    fun getAll(): List<MovieGenreEntity>
}

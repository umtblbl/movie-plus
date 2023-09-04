package com.movieplus.core.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.movieplus.core.data.local.room.model.PopularMovieEntity

@Dao
interface PopularMoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(vararg entity: PopularMovieEntity): LongArray

    @Query("SELECT * FROM popular_movie")
    fun getAll(): List<PopularMovieEntity>
}

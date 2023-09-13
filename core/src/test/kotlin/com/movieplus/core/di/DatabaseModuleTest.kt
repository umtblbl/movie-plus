package com.movieplus.core.di

import android.content.Context
import com.movieplus.core.data.local.room.MovieDatabase
import com.movieplus.core.data.local.room.dao.MovieGenresDao
import com.movieplus.core.data.local.room.dao.PopularMoviesDao
import com.movieplus.core.di.module.DatabaseModule
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class DatabaseModuleTest {

    private lateinit var databaseModule: DatabaseModule

    @Before
    fun setUp() {
        databaseModule = DatabaseModule()
    }

    @Test
    fun verifyProvidedMoviegenresDao() {
        val movieDatabase: MovieDatabase = mockk()
        val movieGenresDao: MovieGenresDao = mockk()

        every { movieDatabase.movieGenresDao() } returns movieGenresDao

        assertEquals(
            movieGenresDao,
            databaseModule.provideMovieGenresDao(movieDatabase)
        )
        verify { movieDatabase.movieGenresDao() }
    }

    @Test
    fun verifyProvidedPopularMoviesDao() {
        val movieDatabase: MovieDatabase = mockk()
        val popularMoviesDao: PopularMoviesDao = mockk()

        every { movieDatabase.popularMoviesDao() } returns popularMoviesDao

        assertEquals(
            popularMoviesDao,
            databaseModule.providePopularMoviesDao(movieDatabase)
        )
        verify { movieDatabase.popularMoviesDao() }
    }
}

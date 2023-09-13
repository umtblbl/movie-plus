package com.movieplus.core.di

import com.movieplus.core.data.local.room.dataSource.TmdbLocalDataSource
import com.movieplus.core.data.mediator.PopularMovieRemoteMediator
import com.movieplus.core.data.mediator.TopRatedRemoteMediator
import com.movieplus.core.data.remote.api.dataSource.TmdbRemoteDataSource
import com.movieplus.core.di.module.RepositoryModule
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class RepositoryModuleTest {

    private lateinit var repositoryModule: RepositoryModule

    @Before
    fun setUp() {
        repositoryModule = RepositoryModule()
    }

    @Test
    fun verifyProvidedGithubRepository() {
        val tmdbLocalDataSource = mockk<TmdbLocalDataSource>()
        val tmdbRemoteDataSource = mockk<TmdbRemoteDataSource>()
        val popularMovieRemoteMediator = mockk<PopularMovieRemoteMediator>()
        val topRatedRemoteMediator = mockk<TopRatedRemoteMediator>()
        val movieRepository = repositoryModule.provideMovieRepository(
            tmdbLocalDataSource,
            tmdbRemoteDataSource,
            popularMovieRemoteMediator,
            topRatedRemoteMediator
        )

        Assert.assertEquals(tmdbLocalDataSource, movieRepository.tmdbLocalDataSource)
        Assert.assertEquals(tmdbRemoteDataSource, movieRepository.tmdbRemoteDataSource)
        Assert.assertEquals(popularMovieRemoteMediator, movieRepository.popularMovieRemoteMediator)
        Assert.assertEquals(topRatedRemoteMediator, movieRepository.topRatedRemoteMediator)
    }
}

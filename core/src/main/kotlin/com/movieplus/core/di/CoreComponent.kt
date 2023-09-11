package com.movieplus.core.di

import android.content.Context
import com.movieplus.core.data.repository.MovieRepository
import com.movieplus.core.di.module.*
import com.movieplus.core.util.NetworkHeader
import dagger.Component
import javax.inject.Singleton

/**
 * Core component that all module's components depend on.
 *
 * @see Component
 */
@Singleton
@Component(
    modules = [
        ContextModule::class,
        NetworkModule::class,
        DataSourceModule::class,
        MediatorModule::class,
        RepositoryModule::class,
        DatabaseModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
    fun networkHeader(): NetworkHeader

    fun movieRepository(): MovieRepository
}

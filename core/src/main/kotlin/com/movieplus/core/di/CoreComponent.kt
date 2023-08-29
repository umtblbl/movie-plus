package com.movieplus.core.di

import android.content.Context
import com.movieplus.core.di.module.ContextModule
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
        ContextModule::class
    ]
)
interface CoreComponent {
    fun context(): Context
}

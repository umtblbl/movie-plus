package com.movieplus.core.di.module

import android.app.Application
import android.content.Context
import com.movieplus.core.util.NetworkHeader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Class that contributes to the object graph [CoreComponent].
 *
 * @see Module
 */
@Module
class ContextModule(
    private val application: Application,
    private val networkHeader: NetworkHeader
) {

    /**
     * Create a provider method binding for [Context].
     *
     * @return Instance of context.
     * @see Provides
     */
    @Singleton
    @Provides
    fun provideContext(): Context = application

    @Singleton
    @Provides
    fun provideNetworkHeader(): NetworkHeader = networkHeader
}

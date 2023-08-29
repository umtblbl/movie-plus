package com.movieplus.app.di

import com.movieplus.app.MoviePlusApp
import com.movieplus.core.di.CoreComponent
import com.movieplus.core.di.scope.AppScope
import dagger.Component

/**
 * App component that application component's components depend on.
 *
 * @see Component
 */
@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class]
)
interface AppComponent {

    /**
     * Inject dependencies on application.
     *
     * @param application The sample application.
     */
    fun inject(application: MoviePlusApp)
}

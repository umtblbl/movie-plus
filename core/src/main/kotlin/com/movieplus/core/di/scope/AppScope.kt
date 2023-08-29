package com.movieplus.core.di.scope

import javax.inject.Scope

/**
 * Scope for the entire app runtime.
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

package com.movieplus.app

import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompatApplication
import com.movieplus.app.di.DaggerAppComponent
import com.movieplus.core.di.CoreComponent
import com.movieplus.core.di.DaggerCoreComponent
import com.movieplus.core.di.module.ContextModule
import com.movieplus.core.util.NetworkHeader

/**
 * Base class to maintain application state and start base jobs.
 * Module inherits from SplitCompatApplication for an application approach
 *
 * @see SplitCompatApplication
 */
class MoviePlusApp : SplitCompatApplication() {

    lateinit var coreComponent: CoreComponent

    companion object {
        @JvmStatic
        fun coreComponent(context: Context) =
            (context.applicationContext as? MoviePlusApp)?.coreComponent
    }

    override fun onCreate() {
        super.onCreate()
        initCoreDI()
        initAppDI()
    }

    //region private functions

    private fun initCoreDI() {
        coreComponent = DaggerCoreComponent
            .builder()
            .contextModule(
                ContextModule(
                    this,
                    NetworkHeader(
                        language = "tr-TR"
                    )
                )
            ).build()
    }

    private fun initAppDI() {
        DaggerAppComponent
            .builder()
            .coreComponent(coreComponent)
            .build()
            .inject(this)
    }

    //endregion
}

package com.movieplus.core

object Configs {
    object Network {
        const val BASE_URL: String = BuildConfig.MOVIE_PLUS_API_BASE_URL
        const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MiB
        const val TIME_OUT: Long = 3 * 60
        const val TOKEN: String = ""
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    object Database {
        const val NAME = BuildConfig.MOVIE_PLUS_DATABASE_NAME
        const val VERSION = 1
        const val EXPORT_SCHEME = false
    }
}
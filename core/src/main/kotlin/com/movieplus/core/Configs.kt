package com.movieplus.core

object Configs {
    object Network {
        const val BASE_URL: String = BuildConfig.MOVIE_PLUS_API_BASE_URL
        const val CACHE_SIZE: Long = 10 * 1024 * 1024 // 10 MiB
        const val TIME_OUT: Long = 3 * 60
        const val TOKEN: String = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiYThmNzRmY2M4ZDgwZjFhMTY5NDA0YzQwNjA5NzFjOCIsInN1YiI6IjY0ZWRkNzYxYzYxM2NlMDEyY2M3MDEwYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.LMw5WfpT4ILsRd3NLWVAr167PnCzFpmgoXyeWhzpAeA"
        const val IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
    }

    object Database {
        const val NAME = BuildConfig.MOVIE_PLUS_DATABASE_NAME
        const val VERSION = 1
        const val EXPORT_SCHEME = false
    }
}
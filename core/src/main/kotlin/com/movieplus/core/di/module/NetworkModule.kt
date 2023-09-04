package com.movieplus.core.di.module

import android.os.Environment
import com.movieplus.core.Configs
import com.movieplus.core.data.remote.api.TmdbAPI
import com.movieplus.core.util.HeaderInterceptor
import com.movieplus.core.util.NetworkHeader
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideHeaderInterceptor(
        networkHeader: NetworkHeader
    ) = HeaderInterceptor(networkHeader = networkHeader)

    @Singleton
    @Provides
    fun provideOkhttpClient(
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient {
        val cache = Cache(Environment.getDownloadCacheDirectory(), Configs.Network.CACHE_SIZE)
        return OkHttpClient.Builder()
            .connectTimeout(Configs.Network.TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(Configs.Network.TIME_OUT, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .cache(cache)
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(Configs.Network.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    @Singleton
    @Provides
    fun provideTmdbAPI(
        retrofit: Retrofit
    ): TmdbAPI {
        return retrofit.create(TmdbAPI::class.java)
    }
}

package com.movieplus.core.di

import com.movieplus.core.BuildConfig
import com.movieplus.core.data.remote.api.TmdbAPI
import com.movieplus.core.di.module.NetworkModule
import com.movieplus.core.util.HeaderInterceptor
import com.movieplus.core.util.NetworkHeader
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit


class NetworkModuleTest {

    private lateinit var networkModule: NetworkModule

    @Before
    fun setUp() {
        networkModule = NetworkModule()
    }

    @Test
    fun verifyProvidedHttpClient() {
        val headerInterceptor = HeaderInterceptor(
            NetworkHeader("tr-TR")
        )

        val httpClient = networkModule.provideOkhttpClient(headerInterceptor)

        Assert.assertEquals(1, httpClient.interceptors().size)
    }

    @Test
    fun verifyProvidedRetrofitBuilder() {
        val headerInterceptor = HeaderInterceptor(
            NetworkHeader("tr-TR")
        )
        val okHttp = networkModule.provideOkhttpClient(
            headerInterceptor
        )
        val retrofit = networkModule.provideRetrofit(okHttp)

        assertEquals(BuildConfig.MOVIE_PLUS_API_BASE_URL, retrofit.baseUrl().toString())
    }

    @Test
    fun verifyProvidedTmdbAPI() {
        val retrofit = mockk<Retrofit>()
        val githubAPI = mockk<TmdbAPI>()
        val serviceClassCaptor = slot<Class<*>>()

        every { retrofit.create<TmdbAPI>(any()) } returns githubAPI

        networkModule.provideTmdbAPI(retrofit)

        verify { retrofit.create(capture(serviceClassCaptor)) }
        Assert.assertEquals(TmdbAPI::class.java, serviceClassCaptor.captured)
    }
}

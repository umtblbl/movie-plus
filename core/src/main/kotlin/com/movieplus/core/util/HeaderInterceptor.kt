package com.movieplus.core.util

import com.movieplus.core.Configs
import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private val networkHeader: NetworkHeader
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url()

        // INTERESTING PART to inject query parameters
        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("language", networkHeader.language)
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder().url(url)
            .apply {
                addHeader("Authorization", "Bearer ${Configs.Network.TOKEN}")
            }
        val request = requestBuilder.build()
        return chain.proceed(request)
        /*

        val oldRequest = chain.request()

        val newRequest = chain.request().newBuilder()
            .addHeader("Authorization", "Bearer ${Configs.Network.TOKEN}")
            .build()

        oldRequest.newBuilder()
            .addHeader("Authorization", "Bearer " + Configs.Network.TOKEN)
        val url = oldRequest.url().newBuilder()
            .apply {
                addQueryParameter("language", networkHeader.language)
            }.build()
        val newRequest = oldRequest.newBuilder().url(url).build()
        return chain.proceed(newRequest)*/
    }
}

package com.example.giphy_client.di.modules

import android.content.Context
import com.example.giphy_client.BuildConfig
import com.example.giphy_client.di.BaseApiUrl
import com.example.giphy_client.repository.GiphyApi
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = arrayOf(ContextModule::class))
class ApiModule {
    companion object {
        private const val CONNECT_TIMEOUT_IN_SECONDS: Long = 5
        private const val READ_TIMEOUT_IN_SECONDS: Long = 100
        private const val CACHE_SIZE = 10L * 1024 * 1024 // 10 MB

        private const val API_KEY_HEADER = "api_key"
    }

    @Provides
    @Singleton
    @BaseApiUrl
    fun provideApiUrl(): String = BuildConfig.GIPHY_ENDPOINT

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, @BaseApiUrl url: String): GiphyApi = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(okHttpClient)
        .baseUrl(url)
        .build()
        .create(GiphyApi::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(context: Context): OkHttpClient = with(OkHttpClient.Builder()) {
        cache(Cache(context.cacheDir, CACHE_SIZE))
        connectTimeout(CONNECT_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
        readTimeout(READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)

        addInterceptor(object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                val request = chain
                    .request()
                    .newBuilder()
                    .addHeader(API_KEY_HEADER, BuildConfig.GIPHY_API_KEY)
                    .build()
                return chain.proceed(request)
            }
        })

        addNetworkInterceptor(
            HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        )

        build()
    }
}
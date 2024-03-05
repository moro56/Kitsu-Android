package com.app.core.network.di

import com.app.core.network.BuildConfig
import com.app.core.network.models.StatusCode
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesOkHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }

    @Provides
    fun providesOkHttp(okHttpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor {
                with(it) {
                    val newRequest = request().newBuilder()
                        .header("Accept", "application/vnd.api+json")
                        .header("Content-Type", "application/vnd.api+json")
                        .build()
                    proceed(newRequest)
                }
            }
            .addInterceptor { chain ->
                val response = chain.proceed(chain.request())
                // Check for empty response
                when {
                    !response.isSuccessful -> {
                        response
                    }

                    (response.body?.contentLength()?.takeIf { it >= 0 } != null) -> {
                        response.newBuilder().code(StatusCode.OK.code).build()
                    }

                    else -> {
                        response
                            .newBuilder()
                            .code(StatusCode.OK.code)
                            .body("".toResponseBody("text/plain".toMediaType()))
                            .build()
                    }
                }
            }
            .addInterceptor(okHttpLoggingInterceptor)
            .build()

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .build()
}

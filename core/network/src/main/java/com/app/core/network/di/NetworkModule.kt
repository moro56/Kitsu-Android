package com.app.core.network.di

import com.app.core.network.BuildConfig
import com.app.core.network.api.RestApi
import com.app.core.network.api.RestApiImpl
import com.app.core.network.api.services.KitsuService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
            .addInterceptor(okHttpLoggingInterceptor)
            .build()

    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(BuildConfig.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun providesKitsuService(retrofit: Retrofit): KitsuService =
        retrofit.create(KitsuService::class.java)

    @Provides
    fun providesRestApi(kitsuService: KitsuService): RestApi = RestApiImpl(kitsuService)
}

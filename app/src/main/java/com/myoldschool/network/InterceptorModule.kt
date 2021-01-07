package com.myoldschool.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object InterceptorModule {

    @CustomAnnotationModule.HttpLoggingInterceptorOkHttp
    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }



}
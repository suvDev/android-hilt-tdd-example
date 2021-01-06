package com.myoldschool.network

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Qualifier

@Module
@InstallIn(ActivityComponent::class)
object CustomAnnotationModule {
    @Qualifier
    @Retention(AnnotationRetention.BINARY)
    annotation class HttpLoggingInterceptorOkHttp
}
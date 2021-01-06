package com.myoldschool.network

import com.myoldschool.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ApplicationComponent
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object HiltModule {

    @Singleton
    @Provides
    fun providesApiRepository(
        @CustomAnnotationModule.HttpLoggingInterceptorOkHttp okHttpClient: OkHttpClient
    ): ApiRepository {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(ApiRepository::class.java)
    }

    @Singleton
    @Provides
    fun providesCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
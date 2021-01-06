package com.myoldschool.utils

import com.myoldschool.network.ApiRepository
import com.myoldschool.network.CustomAnnotationModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import io.reactivex.disposables.CompositeDisposable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ActivityComponent::class)
object HiltModule {

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

    @Provides
    fun providesCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
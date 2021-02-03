package com.myoldschool.mockapi

import com.google.gson.Gson
import com.myoldschool.mockapi.ApiDispatcher
import com.myoldschool.network.ApiRepository
import com.myoldschool.viewmodels.MainActivityViewModel
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseUITest {
    protected var mockWebServer = MockWebServer()

    @Before
    open fun setup() {
        mockWebServer.start(5000)
        Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .build()
                .create(ApiRepository::class.java).getAllRecords()
        mockWebServer.dispatcher = ApiDispatcher()
    }

    @After
    open fun teardown() {
        mockWebServer.shutdown()
    }
}

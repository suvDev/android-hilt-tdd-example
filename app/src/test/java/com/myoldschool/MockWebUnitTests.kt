package com.myoldschool

import com.google.gson.Gson
import com.myoldschool.network.ApiRepository
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@RunWith(JUnit4::class)
class MockWebUnitTests {

    private val server: MockWebServer = MockWebServer()
    private val MOCK_WEBSERVER_PORT = 5000

    lateinit var apiRepository: ApiRepository

    @Before
    fun init() {
        server.start(MOCK_WEBSERVER_PORT)

        apiRepository = Retrofit.Builder()
            .baseUrl(server.url("/"))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiRepository::class.java)

    }

    @Test
    fun testAPI(){
        server.apply {
            enqueue(MockResponse().setBody(MockResponseFileReader("student.json").content))
        }
        apiRepository.getAllRecords().test()
            .awaitDone(3, TimeUnit.SECONDS)
            .assertComplete()
            .assertValueCount(1)
            .assertValue {
                it.size == 1
            }
            .assertNoErrors()

    }

    @After
    fun shutdown() {
        server.shutdown()
    }


}
package com.myoldschool

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)
    private val mockWebServer: MockWebServer = MockWebServer()
    private val MOCK_WEBSERVER_PORT = 5000


    @Before
    @Throws(IOException::class, InterruptedException::class)
    fun setup() {
        mockWebServer.apply {
            enqueue(MockResponse().setBody(MockRespFileReader("student.json").content))
        }
        mockWebServer.start(MOCK_WEBSERVER_PORT)
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testProgressBarVisible(){
        // Given: test Progress bar is visible or hidden on activity launch
        // When: MainActivity is launched
        // Then: Progress bar should be visible
        onView(withId(R.id.progressbar)).check(matches(isDisplayed()))
        Thread.sleep(10000)
    }

}
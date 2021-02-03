package com.myoldschool

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.myoldschool.mockapi.BaseUITest
import com.myoldschool.viewmodels.MainActivityViewModel
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock


@RunWith(AndroidJUnit4::class)
class MainActivityTest: BaseUITest() {

//    @get:Rule
//    var mActivityRule = ActivityScenarioRule(MainActivity::class.java)

//    @get:Rule
//    var mActivityTestRule = IntentsTestRule<MainActivity>(
//            MainActivity::class.java, true, false
//    )

    private lateinit var viewModel: MainActivityViewModel

    @get:Rule
    var mActivityTestRule = IntentsTestRule<MainActivity>(
            MainActivity::class.java, true, false
    )


    @Before
     override fun setup() {
        super.setup()
        viewModel = mock(MainActivityViewModel::class.java)
        mActivityTestRule.launchActivity(null)
    }

    @After
    override fun teardown() {
        super.teardown()
    }

    @Test
    fun testProgressBarVisible(){
        // Given: test Progress bar is visible or hidden on activity launch
        // When: MainActivity is launched
        // Then: Progress bar should be visible
        onView(isRoot()).perform(waitFor(5000))
        onView(withId(R.id.progressbar)).check(matches(isDisplayed()))
    }

}
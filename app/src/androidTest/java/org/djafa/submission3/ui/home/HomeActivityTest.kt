package org.djafa.submission3.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.djafa.submission3.R
import org.djafa.submission3.utils.DataDummy
import org.djafa.submission3.utils.EspressoIdlingResource
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Test

class HomeActivityTest {
    private val dummyMovies = DataDummy.generateDummyMovies()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

/*    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)*/

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tvshows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tvshows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @Test
    fun loadDetailMovies() {
        onView(withText("MOVIES")).perform(click())
        onView(allOf(withId(R.id.rv_movies), isDisplayed()))
        onView(allOf(withId(R.id.rv_movies))).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(allOf(withId(R.id.text_title_mv), isDisplayed()))
        onView(allOf(withId(R.id.text_title_mv), withText(dummyMovies[0].title)))
        onView(allOf(withId(R.id.text_rate_mv), isDisplayed()))
        onView(allOf(withId(R.id.text_rate_mv), withText(dummyMovies[0].voteAverage)))
        onView(allOf(withId(R.id.text_overview_mv), isDisplayed()))
        onView(allOf(withId(R.id.text_overview_mv), withText(dummyMovies[0].overview)))
        onView(allOf(withId(R.id.image_path_mv), isDisplayed()))
        onView(allOf(withId(R.id.image_path_mv), withText(dummyMovies[0].poster_path)))
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(allOf(withId(R.id.rv_tvshows), isDisplayed()))
        onView(allOf(withId(R.id.rv_tvshows))).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(allOf(withId(R.id.text_title_tv), isDisplayed()))
        onView(allOf(withId(R.id.text_title_tv), withText(dummyTvShows[0].title)))
        onView(allOf(withId(R.id.text_rate_tv), isDisplayed()))
        onView(allOf(withId(R.id.text_rate_tv), withText(dummyTvShows[0].voteAverage)))
        onView(allOf(withId(R.id.text_overview_tv), isDisplayed()))
        onView(allOf(withId(R.id.text_overview_tv), withText(dummyTvShows[0].overview)))
        onView(allOf(withId(R.id.image_path_tv), isDisplayed()))
        onView(allOf(withId(R.id.image_path_tv), withText(dummyTvShows[0].poster_path)))
    }

}

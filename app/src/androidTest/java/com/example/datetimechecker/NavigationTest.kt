package com.example.datetimechecker

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import org.junit.Assert.*
import org.junit.Test

class NavigationTest{
    @Test
    fun test_navigation() {
        val scenario=ActivityScenario.launch(MainActivity::class.java);

        onView(withId(R.id.nextScreenButton)).perform(click());
        onView(withId(R.id.fragment_movie_detail)).check(matches(isDisplayed()));


        onView(withId(R.id.movie_star_actors)).perform(click());
        onView(withId(R.id.fragment_star_actors)).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.movie_directiors)).perform(click());
        onView(withId(R.id.fragment_director)).check(matches(isDisplayed()));

    }
}
package com.example.datetimechecker

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Test

class MainActivityTest {

    @Test
    fun testUserInterface() {
        val scenario = ActivityScenario.launch(MainActivity::class.java);
        val normalDay = "1";
        val normalMonth = "1";
        val normalYear = "1111";
        onView(withId(R.id.titleTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.titleTextView)).check(matches(withText("Date Time Checker")));
        onView(withId(R.id.dayEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.monthEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.yearEditText)).check(matches(isDisplayed()));
        onView(withId(R.id.dayTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.monthTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.yearTextView)).check(matches(isDisplayed()));
        onView(withId(R.id.clearButton)).check(matches(isDisplayed()));
        onView(withId(R.id.checkButton)).check(matches(isDisplayed()));

        //region day
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for day is incorrect format")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.dayEditText)).perform(typeText("a"));
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for day is incorrect format")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.dayEditText)).perform(clearText());
        onView(withId(R.id.dayEditText)).perform(typeText(normalDay));
        //endregion

        //region month
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for month is incorrect format")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());


        onView(withId(R.id.monthEditText)).perform(typeText("a"));
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for month is incorrect format")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.monthEditText)).perform(clearText());
        onView(withId(R.id.monthEditText)).perform(typeText(normalMonth));
        //endregion

        //region year
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for year is incorrect format")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());


        onView(withId(R.id.yearEditText)).perform(typeText("a"));
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for year is incorrect format")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.yearEditText)).perform(clearText());
        onView(withId(R.id.yearEditText)).perform(typeText(normalYear));

        //endregion

        //region day of out range

        onView(withId(R.id.dayEditText)).perform(clearText());
        onView(withId(R.id.dayEditText)).perform(typeText("100"));

        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for day is out of range")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.dayEditText)).perform(clearText());
        onView(withId(R.id.dayEditText)).perform(typeText("-1"));

        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for day is out of range")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.dayEditText)).perform(clearText());
        onView(withId(R.id.dayEditText)).perform(typeText(normalDay));
        //endregion

        //region month out of range

        onView(withId(R.id.monthEditText)).perform(clearText());
        onView(withId(R.id.monthEditText)).perform(typeText("100"));

        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for month is out of range")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.monthEditText)).perform(clearText());
        onView(withId(R.id.monthEditText)).perform(typeText("-1"));

        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for month is out of range")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.monthEditText)).perform(clearText());
        onView(withId(R.id.monthEditText)).perform(typeText(normalMonth));
        //endregion

        //region month out of range

        onView(withId(R.id.yearEditText)).perform(clearText());
        onView(withId(R.id.yearEditText)).perform(typeText("100"));

        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for year is out of range")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.yearEditText)).perform(clearText());
        onView(withId(R.id.yearEditText)).perform(typeText("3001"));

        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("Input data for year is out of range")).check(matches(isDisplayed()));
        onView(isRoot()).perform(pressBack());

        onView(withId(R.id.yearEditText)).perform(clearText());
        onView(withId(R.id.yearEditText)).perform(typeText(normalYear));
        //endregion

        //region check correct date
        onView(withId(R.id.checkButton)).perform(click());
        onView(withText("$normalDay/$normalMonth/$normalYear is correct date time!")).check(
            matches(
                isDisplayed()
            )
        );
        onView(isRoot()).perform(pressBack());

        //endregion

        //region clear button
        onView(withId(R.id.clearButton)).perform(click());
        onView(withId(R.id.dayEditText)).check(matches(withText("")));
        onView(withId(R.id.monthEditText)).check(matches(withText("")));
        onView(withId(R.id.yearEditText)).check(matches(withText("")));
        //endregion


    }


}
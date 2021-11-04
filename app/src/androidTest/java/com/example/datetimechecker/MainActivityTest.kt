package com.example.datetimechecker

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert.assertEquals
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

    @Test
    fun testFunction(){
        val scenario = ActivityScenario.launch(MainActivity::class.java);
        var day="1";
        var month="6";
        var year="2000";
        //region 1/6/2000
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        //region 2/6/2000
        day="2";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        // region 15/6/2000
        day="15";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        // region 30/6/2000
        day="30";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        // region 31/6/2000
        day="31";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //false
        onView(withText("$day/$month/$year is NOT correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion


        // region 15/1/2000
        day="15";
        month="1";
        year="2000";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion


        // region 15/2/2000
        day="15";
        month="2";
        year="2000";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

    // region 15/11/2000
        day="15";
        month="11";
        year="2000";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion


        // region 15/12/2000
        day="15";
        month="12";
        year="2000";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        // region 15/6/1801
        day="15";
        month="6";
        year="1801";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion


        // region 15/6/1802
        day="15";
        month="6";
        year="1802";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        // region 15/6/2998
        day="15";
        month="6";
        year="1801";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion

        // region 15/6/2999
        day="15";
        month="6";
        year="2999";
        onView(withId(R.id.dayEditText)).perform(typeText(day));
        onView(withId(R.id.monthEditText)).perform(typeText(month));
        onView(withId(R.id.yearEditText)).perform(typeText(year));
        onView(withId(R.id.checkButton)).perform(click());
        //true
        onView(withText("$day/$month/$year is correct date time!")).check(matches(isDisplayed()));

        onView(isRoot()).perform(pressBack());
        onView(withId(R.id.clearButton)).perform(click());

        //endregion


//        assertEquals(true,  mainActivity.isValidDate(2998,6,15))
//        assertEquals(true,  mainActivity.isValidDate(2999,6,15))
    }

}
package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {
    @get:Rule
    var mainActivityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft", appContext.packageName)
    }

    @Test
    fun ensureImageShowedAndShowButtonHiddenWhenShowButtonClicked() {
        onView(withId(R.id.profileImageShowButton))
            .perform(click())

        onView(withId(R.id.profileImageShowButton))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.profileImage))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.profileImageCloseButton))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    @Test
    fun ensureImageClosedAndShowButtonShowedWhenCloseButtonClicked() {
        onView(withId(R.id.profileImageShowButton))
            .perform(click())
        onView(withId(R.id.profileImageCloseButton))
            .perform(click())

        onView(withId(R.id.profileImageShowButton))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.profileImage))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.profileImageCloseButton))
            .check(matches(withEffectiveVisibility(Visibility.GONE)))
    }
}
package grindstone.sharpening.shoppinglist

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class ShoppingListTests {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun add_product() {
        onView(withId(R.id.fab_addProduct)).perform(click())

        onView(withId(R.id.editTextAddProduct)).perform(typeText("Product inserted by tests"))

        onView(withText(R.string.ok)).perform(click())

        onView(withText("Product inserted by tests")).check(matches(hasTextColor(R.color.primaryTextColor)))

        onView(withText("Product inserted by tests")).perform(click())

        onView(withText("Product inserted by tests")).check(matches(hasTextColor(R.color.doneTextColor)))

        onView(withText("Product inserted by tests")).perform(click())

        onView(withText("Product inserted by tests")).check(matches(hasTextColor(R.color.primaryTextColor)))

    }

}
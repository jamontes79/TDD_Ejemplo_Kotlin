package com.jamontes79.tdd_ejemplo_kotlin.login


import android.content.Intent
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4


import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.action.ViewActions.typeText
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import com.jamontes79.tdd_ejemplo_kotlin.R
import org.junit.Assert.*

/**
 * Created by jamontes79 on 30/09/2017.
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    internal var activityTestRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun checkUserNameEditTextIsDisplayed() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.txt_user_name)).check(matches(isDisplayed()))
    }

    @Test
    fun checkPasswordEditTextIsDisplayed() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.txt_password)).check(matches(isDisplayed()))
    }

    @Test
    fun checkErrorMessageIsDisplayedForEmptyData() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click())
        onView(withText(R.string.error_user_password)).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginSuccess() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.txt_user_name)).perform(typeText("user"), closeSoftKeyboard())
        onView(withId(R.id.txt_password)).perform(typeText("password"), closeSoftKeyboard())
        onView(withId(R.id.btn_login)).check(matches(isDisplayed())).perform(click())
        onView(withText(R.string.login_ok)).check(matches(isDisplayed()))

    }
}
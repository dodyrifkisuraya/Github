package com.dorizu.github.presentation.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.dorizu.github.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentTest{
    @get:Rule
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun search_user(){
        //Memastikan SearchView ditampilkan
        onView(withId(R.id.sv_user)).check(matches(isDisplayed()))
        //Memberikan aksi klik pada SearchView
        onView(withId(R.id.sv_user)).perform(click())
        //Memberikan input username
        onView(withId(R.id.sv_user)).perform(
            typeText("isfa"),
            closeSoftKeyboard()
        )
        //Menunggu proses search
        Thread.sleep(2000)
        //Memastikan recycle view user ditampilkan
        onView(withId(R.id.rv_user)).check(matches(isDisplayed()))
        //Memastikan salah satu item list ditampilkan
        onView(withText("isfaaghyth")).check(matches(isDisplayed()))
    }

    @Test
    fun show_user_detail_and_repository(){
        //Memastikan SearchView ditampilkan
        onView(withId(R.id.sv_user)).check(matches(isDisplayed()))
        //Memberikan aksi klik pada SearchView
        onView(withId(R.id.sv_user)).perform(click())
        //Memberikan input username
        onView(withId(R.id.sv_user)).perform(
            scrollTo(),
            typeText("isfa"),
            closeSoftKeyboard()
        )
        //Menunggu proses search
        Thread.sleep(2000)
        //Memastikan recycle view user ditampilkan
        onView(withId(R.id.rv_user)).check(matches(isDisplayed()))
        //Memastikan salah satu item list ditampilkan
        onView(withText("isfaaghyth")).check(matches(isDisplayed()))
        //Memberikan aksi klik pada salah satu item
        onView(withText("isfaaghyth")).perform(click())
        //Menunggu proses get user detail
        Thread.sleep(2000)
        //Memastikan image profile ditampilkan
        onView(withId(R.id.iv_profile_user)).check(matches(isDisplayed()))
        //Memastikan nama ditampilkan
        onView(withId(R.id.tv_name_user)).check(matches(isDisplayed()))
        //Memastikan username ditampilkan
        onView(withId(R.id.tv_uname)).check(matches(isDisplayed()))
        //Memastikan bio ditampilkan
        onView(withId(R.id.tv_motto)).check(matches(isDisplayed()))
        //Memastikan list repo ditampilkan
        onView(withId(R.id.rv_repository)).check(matches(isDisplayed()))
        //Memberikan aksi scroll ke repo ke 10
        onView(withId(R.id.rv_repository)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                10,
                click()
            )
        )
    }
}
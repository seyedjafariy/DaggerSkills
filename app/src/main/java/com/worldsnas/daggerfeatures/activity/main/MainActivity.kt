package com.worldsnas.daggerfeatures.activity.main

import android.content.SharedPreferences
import android.os.Bundle
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.activity.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
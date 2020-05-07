package com.worldsnas.daggerfeatures.activity.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.activity.BaseActivity
import com.worldsnas.daggerfeatures.di.findAppComponent
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    @Inject
    override lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent
            .builder()
            .sharedPreferencesComponent(findAppComponent().provideSharedPrefComponent())
            .build()
            .inject(this)
    }
}
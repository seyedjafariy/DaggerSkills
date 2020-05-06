package com.worldsnas.daggerfeatures.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.network.UserAPI
import javax.inject.Inject

class NetworkUsersActivity : AppCompatActivity() {

    @Inject
    lateinit var userApi: UserAPI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerApp.appComponent.inject(this)
    }
}
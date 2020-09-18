package com.worldsnas.daggerfeatures.activity.networkUsers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.network.UserAPI
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NetworkUsersActivity : AppCompatActivity() {

    @Inject
    lateinit var userApi: UserAPI

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
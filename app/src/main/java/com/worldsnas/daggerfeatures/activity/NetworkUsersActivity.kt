package com.worldsnas.daggerfeatures.activity

import android.os.Bundle
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.R
import com.worldsnas.daggerfeatures.network.UserAPI
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Inject

class NetworkUsersActivity : BaseActivity() {

    @Inject
    lateinit var retrofit: Retrofit


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val service: UserAPI = retrofit.create()

        DaggerApp.appComponent.inject(this)
    }
}
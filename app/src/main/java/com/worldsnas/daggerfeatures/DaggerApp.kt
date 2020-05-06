package com.worldsnas.daggerfeatures

import android.app.Application
import com.worldsnas.daggerfeatures.di.AppComponent
import com.worldsnas.daggerfeatures.di.DaggerAppComponent

class DaggerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(
                this
            )
            .also {
                it.inject(this)
            }
    }

    companion object {

        lateinit var appComponent: AppComponent
    }
}
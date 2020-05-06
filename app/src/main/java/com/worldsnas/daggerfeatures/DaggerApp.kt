package com.worldsnas.daggerfeatures

import android.app.Application
import com.worldsnas.daggerfeatures.di.AppComponent
import com.worldsnas.daggerfeatures.di.AppComponentProvider
import com.worldsnas.daggerfeatures.di.DaggerAppComponent

class DaggerApp : Application(), AppComponentProvider {

    private lateinit var appComponent: AppComponent

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

    override fun provideAppComponent(): AppComponent =
        appComponent
}
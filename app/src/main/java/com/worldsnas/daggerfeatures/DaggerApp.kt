package com.worldsnas.daggerfeatures

import android.app.Application
import com.worldsnas.daggerfeatures.db.DatabaseModule
import com.worldsnas.daggerfeatures.di.AppComponent
import com.worldsnas.daggerfeatures.di.AppModule
import com.worldsnas.daggerfeatures.di.DaggerAppComponent
import com.worldsnas.daggerfeatures.di.OkHttpModule

class DaggerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .factory()
            .create(
                OkHttpModule(),
                AppModule(),
                DatabaseModule(),
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
package com.worldsnas.daggerfeatures

import android.app.Application
import com.worldsnas.daggerfeatures.di.AppComponent
import com.worldsnas.daggerfeatures.di.AppComponentProvider
import com.worldsnas.daggerfeatures.di.DaggerAppComponent
import com.worldsnas.daggerfeatures.di.contextcomponent.DaggerContextComponent
import com.worldsnas.daggerfeatures.di.databasecomponent.DaggerDatabaseComponent
import com.worldsnas.daggerfeatures.di.networkcomponent.DaggerNetworkComponent
import com.worldsnas.daggerfeatures.di.sharedprefcomponent.DaggerSharedPreferencesComponent

class DaggerApp : Application(), AppComponentProvider {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        val context = DaggerContextComponent.factory().create(this)
        val network = DaggerNetworkComponent.builder().contextComponent(context).build()
        val database = DaggerDatabaseComponent.builder().build()
        val sharedPreferences = DaggerSharedPreferencesComponent.factory().create(context)

        appComponent = DaggerAppComponent
            .factory()
            .create(
                context,
                network,
                database,
                sharedPreferences
            )
            .also {
                it.inject(this)
            }
    }

    override fun provideAppComponent(): AppComponent =
        appComponent
}
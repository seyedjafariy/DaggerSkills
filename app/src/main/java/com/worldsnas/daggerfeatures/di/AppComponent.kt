package com.worldsnas.daggerfeatures.di

import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.di.contextcomponent.ContextComponent
import com.worldsnas.daggerfeatures.di.databasecomponent.DatabaseComponent
import com.worldsnas.daggerfeatures.di.networkcomponent.NetworkComponent
import com.worldsnas.daggerfeatures.di.sharedprefcomponent.SharedPreferencesComponent
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@AppScope
@Singleton
@Component(
)
interface AppComponent {

    fun provideContextComponent(): ContextComponent
    fun provideNetworkComponent(): NetworkComponent
    fun provideDatabaseComponent(): DatabaseComponent
    fun provideSharedPrefComponent(): SharedPreferencesComponent

    fun inject(app: DaggerApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance
            context : ContextComponent,
            @BindsInstance
            network : NetworkComponent,
            @BindsInstance
            database : DatabaseComponent,
            @BindsInstance
            sharedPrefs : SharedPreferencesComponent
        ): AppComponent
    }
}
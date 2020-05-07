package com.worldsnas.daggerfeatures.di.sharedprefcomponent

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
object SharedPrefModule {
    @Provides
    @JvmStatic
    fun provideSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences("app", Context.MODE_PRIVATE)
}
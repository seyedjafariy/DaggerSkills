package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule{

    @Provides
    fun provideSharedPreferences(app : Application) =
        app.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    fun provideRepository(repo : UserRepositoryImpl) : UserRepository =
        repo
}
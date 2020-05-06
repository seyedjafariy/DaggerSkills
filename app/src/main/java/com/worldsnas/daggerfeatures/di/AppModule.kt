package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object AppModule {

    @Provides
    @JvmStatic
    fun provideSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    @JvmStatic
    fun provideRepository(repo: UserRepositoryImpl): UserRepository =
        repo
}
package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Application
) {

    @Provides
    fun provideApplication() = context

    @Provides
    fun provideSharedPreferences() =
        context.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    fun provideRepository(repo : UserRepositoryImpl) : UserRepository =
        repo
}
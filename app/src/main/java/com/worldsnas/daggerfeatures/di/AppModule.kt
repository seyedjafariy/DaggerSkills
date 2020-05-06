package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.ViewModelFactory
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.Module
import dagger.Provides

@Module
class AppModule(
    private val context: Context
) {

    @Provides
    fun provideContext() = context

    @Provides
    fun provideApplication() = context.applicationContext as Application

    @Provides
    fun provideSharedPreferences() =
        context.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    fun provideViewModelProviderFactory(factory : ViewModelFactory) : ViewModelProvider.Factory =
        factory

    @Provides
    fun provideRepository(repo : UserRepositoryImpl) : UserRepository =
        repo
}
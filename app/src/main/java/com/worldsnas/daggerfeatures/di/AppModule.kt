package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.ViewModelFactory
import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.Reusable
import javax.inject.Singleton

@Module
class AppModule(
    private val context: Context
) {

    @Provides
    @Singleton
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideApplication() = context.applicationContext as Application

    @Provides
    @Singleton
    fun provideSharedPreferences() =
        context.getSharedPreferences("app", Context.MODE_PRIVATE)

    @Provides
    @Singleton
    fun provideViewModelFactory() = ViewModelFactory()

    @Provides
    @Singleton
    fun provideViewModelProviderFactory(factory : ViewModelFactory) : ViewModelProvider.Factory =
        factory

    @Provides
    @Singleton
    fun provideRepositoryImpl(database : DaggerDatabase) : UserRepositoryImpl =
        UserRepositoryImpl(database)

    @Provides
    @Singleton
    fun provideRepository(repo : UserRepositoryImpl) : UserRepository =
        repo
}
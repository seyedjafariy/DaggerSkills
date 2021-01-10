package com.worldsnas.daggerfeatures.di

import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.db.DaggerDatabase_Impl
import com.worldsnas.daggerfeatures.db.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabaseImpl(): DaggerDatabase =
        DaggerDatabase_Impl()

    @Provides
    fun provideUserDAO(database: DaggerDatabase): UserDao =
        database.userDao()
}
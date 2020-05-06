package com.worldsnas.daggerfeatures.db

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseImpl() : DaggerDatabase =
        DaggerDatabase_Impl()
}
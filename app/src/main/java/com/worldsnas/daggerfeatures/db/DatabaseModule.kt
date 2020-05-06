package com.worldsnas.daggerfeatures.db

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {

    @Provides
    @Singleton
    @JvmStatic
    fun provideDatabaseImpl() : DaggerDatabase =
        DaggerDatabase_Impl()

    @Provides
    @JvmStatic
    fun provideUserDAO(database : DaggerDatabase) : UserDao =
        database.userDao()
}
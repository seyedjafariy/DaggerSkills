package com.worldsnas.daggerfeatures.di.databasecomponent

import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.db.DaggerDatabase_Impl
import com.worldsnas.daggerfeatures.db.UserDao
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    @DatabaseScope
    @JvmStatic
    fun provideDatabaseImpl(): DaggerDatabase =
        DaggerDatabase_Impl()

    @Provides
    @JvmStatic
    fun provideUserDAO(database: DaggerDatabase): UserDao =
        database.userDao()
}
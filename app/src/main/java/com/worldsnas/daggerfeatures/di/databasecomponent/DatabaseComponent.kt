package com.worldsnas.daggerfeatures.di.databasecomponent

import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.db.UserDao
import dagger.Component
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class DatabaseScope

@DatabaseScope
@Component(
    modules = [DatabaseModule::class]
)
interface DatabaseComponent {

    fun provideDatabase() : DaggerDatabase

    fun provideUserDao(): UserDao
}
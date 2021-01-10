package com.worldsnas.daggerfeatures.activity.list

import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class ListModule {

    @Binds
    abstract fun bindRepo(repo : UserRepositoryImpl) : UserRepository
}
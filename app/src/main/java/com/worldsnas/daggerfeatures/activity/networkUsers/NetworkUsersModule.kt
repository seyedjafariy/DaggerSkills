package com.worldsnas.daggerfeatures.activity.networkUsers

import com.worldsnas.daggerfeatures.network.UserAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import retrofit2.Retrofit
import retrofit2.create

@Module
@InstallIn(ActivityComponent::class)
object NetworkUsersModule {

    @Provides
    fun provideUserAPI(
        retrofit : Retrofit
    ): UserAPI = retrofit.create()
}
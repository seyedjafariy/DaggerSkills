package com.worldsnas.daggerfeatures.activity.networkUsers

import com.worldsnas.daggerfeatures.di.ActivityScope
import com.worldsnas.daggerfeatures.network.UserAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.create

@Module
object NetworkUsersModule {

    @Provides
    @JvmStatic
    @ActivityScope
    fun provideUserAPI(
        retrofit : Retrofit
    ): UserAPI = retrofit.create()
}
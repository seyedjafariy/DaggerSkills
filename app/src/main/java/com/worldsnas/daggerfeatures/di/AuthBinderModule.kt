package com.worldsnas.daggerfeatures.di

import com.worldsnas.daggerfeatures.network.AuthTokenAdderInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor

@Module
@InstallIn(ApplicationComponent::class)
abstract class AuthBinderModule {

    @Binds
    abstract fun bindAuthinterceptor(interceptor: AuthTokenAdderInterceptor):
            Interceptor
}
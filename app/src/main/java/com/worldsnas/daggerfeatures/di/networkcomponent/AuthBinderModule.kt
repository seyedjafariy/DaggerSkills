package com.worldsnas.daggerfeatures.di.networkcomponent

import com.worldsnas.daggerfeatures.network.AuthTokenAdderInterceptor
import dagger.Binds
import dagger.Module
import okhttp3.Interceptor

@Module
abstract class AuthBinderModule {

    @Binds
    abstract fun bindAuthinterceptor(interceptor: AuthTokenAdderInterceptor):
            Interceptor
}
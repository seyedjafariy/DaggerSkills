package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.ViewModelFactory
import com.worldsnas.daggerfeatures.network.AuthTokenAdderInterceptor
import dagger.Binds
import dagger.Module
import okhttp3.Interceptor

@Module
abstract class BinderModule {

    @Binds
    abstract fun bindAuthinterceptor(interceptor : AuthTokenAdderInterceptor) :
            Interceptor

    @Binds
    abstract fun bindViewModelFactory(factory : ViewModelFactory) :
            ViewModelProvider.Factory

    @Binds
    abstract fun bindContext(app : Application) : Context
}
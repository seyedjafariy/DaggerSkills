package com.worldsnas.daggerfeatures.di.networkcomponent

import com.worldsnas.daggerfeatures.di.contextcomponent.ContextComponent
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NetworkScope


@NetworkScope
@Component(
    dependencies = [ContextComponent::class],
    modules = [OkHttpModule::class, AuthBinderModule::class]
)
interface NetworkComponent {

    fun provideOkHttp(): OkHttpClient
    fun provideRetrofit(): Retrofit
}
package com.worldsnas.daggerfeatures.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.ViewModelProvider
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.db.DatabaseModule
import com.worldsnas.daggerfeatures.db.UserDao
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
import dagger.BindsInstance
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@AppScope
@Singleton
@Component(
    modules = [
        DatabaseModule::class,
        OkHttpModule::class,
        AppModule::class,
        BinderModule::class
    ]
)
interface AppComponent {

    fun provideDatabase(): DaggerDatabase
    fun provideOkHttp(): OkHttpClient

    @OkHttpQualifier
    fun secondOkHttp(): OkHttpClient
    fun provideRetrofit(): Retrofit
    fun provideContext(): Context
    fun provideApplication(): Context
    fun provideRepositoryImpl(): UserRepositoryImpl
    fun provideRepository(): UserRepository
    fun provideUserDao(): UserDao
    fun provideSharedPreferences() : SharedPreferences
    fun provideViewModelFactory() : ViewModelProvider.Factory

    fun inject(app: DaggerApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance app : Application
        ) : AppComponent
    }
}
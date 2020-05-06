package com.worldsnas.daggerfeatures.di

import android.content.Context
import com.worldsnas.daggerfeatures.DaggerApp
import com.worldsnas.daggerfeatures.activity.ListActivity
import com.worldsnas.daggerfeatures.activity.MainActivity
import com.worldsnas.daggerfeatures.activity.NetworkUsersActivity
import com.worldsnas.daggerfeatures.db.DaggerDatabase
import com.worldsnas.daggerfeatures.db.DatabaseModule
import com.worldsnas.daggerfeatures.db.UserDao
import com.worldsnas.daggerfeatures.fragments.*
import com.worldsnas.daggerfeatures.network.UserAPI
import com.worldsnas.daggerfeatures.network.UserRepository
import com.worldsnas.daggerfeatures.network.UserRepositoryImpl
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
        AppModule::class
    ]
)
interface AppComponent {

    fun provideDatabase(): DaggerDatabase
    fun provideOkHttp(): OkHttpClient

    @OkHttpQualifier
    fun secondOkHttp(): OkHttpClient
    fun provideRetrofit(): Retrofit
    fun provideListViewModel(): ListViewModel
    fun provideContext(): Context
    fun provideApplication(): Context
    fun provideRepositoryImpl(): UserRepositoryImpl
    fun provideRepository(): UserRepository
    fun provideUserDao(): UserDao
    fun provideUserAPI(): UserAPI

    fun inject(app: DaggerApp)


    fun inject(main: MainActivity)
    fun inject(list: ListActivity)
    fun inject(detail: NetworkUsersActivity)

    //more screens

    fun inject(first: FirstFragment)
    fun inject(second: SecondFragment)
    fun inject(thirdFragment: ThirdFragment)
    fun inject(fourthFragment: FourthFragment)
}
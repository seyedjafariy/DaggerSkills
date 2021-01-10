package com.worldsnas.daggerfeatures.di

import android.content.Context
import android.util.Log
import com.squareup.moshi.Moshi
import com.worldsnas.daggerfeatures.BuildConfig.DEBUG
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@InstallIn(ApplicationComponent::class)
object OkHttpModule {

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("network", message)
            }
        })

        httpLoggingInterceptor.level =
            if (DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE

        return httpLoggingInterceptor
    }

    @Provides
    fun provideOkhttpCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, 50_000_000)

    @Provides
    fun provideClient(
        loggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: Interceptor,
        cache: Cache
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .cache(cache)
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()
    }

    @Provides
    @OkHttpQualifier
    fun secondOkHttp(client : OkHttpClient): OkHttpClient =
        client.newBuilder()
                //new logic
            .build()

    @Provides
    fun provideMoshi() = Moshi.Builder().build()


    @Provides
    fun provideMoshiConverter(moshi: Moshi) = MoshiConverterFactory.create(moshi)

    @Provides
    fun provideRetrofit(
        moshi: MoshiConverterFactory,
        client : Lazy<OkHttpClient>
    ) = Retrofit.Builder()
        .callFactory(object : Call.Factory {
            override fun newCall(request: Request): Call =
                client.get().newCall(request)
        })
        .baseUrl("https://sample.com")
        .addConverterFactory(moshi)
        .build()
}
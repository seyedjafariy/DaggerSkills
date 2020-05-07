package com.worldsnas.daggerfeatures.di.networkcomponent

import android.app.Application
import android.util.Log
import com.squareup.moshi.Moshi
import com.worldsnas.daggerfeatures.BuildConfig.DEBUG
import dagger.Lazy
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
object OkHttpModule {

    @Provides
    @JvmStatic
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
    @JvmStatic
    fun provideOkhttpCache(app: Application): Cache =
        Cache(app.cacheDir, 50_000_000)

    @Provides
    @NetworkScope
    @JvmStatic
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
    @NetworkScope
    @JvmStatic
    fun secondOkHttp(client : OkHttpClient): OkHttpClient =
        client.newBuilder()
                //new logic
            .build()

    @Provides
    @NetworkScope
    @JvmStatic
    fun provideMoshi() = Moshi.Builder().build()


    @Provides
    @JvmStatic
    fun provideMoshiConverter(moshi: Moshi) = MoshiConverterFactory.create(moshi)

    @Provides
    @NetworkScope
    @JvmStatic
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
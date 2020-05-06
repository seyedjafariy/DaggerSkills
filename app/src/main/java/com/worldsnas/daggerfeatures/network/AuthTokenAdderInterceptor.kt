package com.worldsnas.daggerfeatures.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthTokenAdderInterceptor @Inject constructor(
): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        //add some api auth logic
        chain.proceed(chain.request())
}
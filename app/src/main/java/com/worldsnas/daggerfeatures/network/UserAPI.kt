package com.worldsnas.daggerfeatures.network

import com.worldsnas.daggerfeatures.model.User
import retrofit2.Call
import retrofit2.http.GET

interface UserAPI {

    @GET("users")
    fun getAllUsers(): Call<List<User>>

}
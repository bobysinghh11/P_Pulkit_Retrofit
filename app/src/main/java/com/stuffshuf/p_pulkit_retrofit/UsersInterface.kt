package com.stuffshuf.p_pulkit_retrofit

import retrofit2.Call
import retrofit2.http.GET

interface UsersInterface {

    @GET("/search/users?q=Pulkit%20Aggarwal")
    fun listRespo(): Call<Example>

}
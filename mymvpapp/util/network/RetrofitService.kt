package com.app.mymvpapp.util.network

import com.app.mymvpapp.DataPOJO
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("/api/users")
    suspend fun getUsers1(
        @Query("per_page")size : Int
    ) : DataPOJO
}
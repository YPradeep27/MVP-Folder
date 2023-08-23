package com.app.mymvpapp.data.repositories

import com.app.mymvpapp.DataPOJO
import com.app.mymvpapp.util.network.RetrofitService
import retrofit2.Retrofit
import javax.inject.Inject

class DataRepo
@Inject constructor(private val retrofitService: RetrofitService) {

    suspend fun getData(size : Int) : DataPOJO{
       return retrofitService.getUsers1(size)
    }
}
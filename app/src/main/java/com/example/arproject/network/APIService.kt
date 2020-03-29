package com.example.arproject.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.Headers
import retrofit2.http.POST

val BASE_URL = "http:120.79.19.172:8000/ar/api"

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ApiService {
    @Headers("Content-Type:application/json")
    @POST("location/building_id")
    fun getBuildingId(@Body position: Position):
            Call<Buildings>

    @Headers("Content-Type:application/json")
    @POST("location/building_detail")
    fun getBuildingInfo(@Field("building_id") id:Int): Call<Building>
}

object Api {
    val retrofitService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

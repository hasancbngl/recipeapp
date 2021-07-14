package com.hasancbngl.recepiapp.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RecipeClient {
    private const val BASE_URL = "http://mobile.asosservices.com/sampleapifortest/"
    val retrofit =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

    val api: RecipeApi by lazy {
        retrofit.create(RecipeApi::class.java)
    }
}
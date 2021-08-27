package com.hasancbngl.recepiapp.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RecipeClient @Inject constructor() {
    private val BASE_URL = "https://mobile.asosservices.com/sampleapifortest/"

    @Provides
    @Singleton
    fun retrofitBuilder() =
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create()).build()

    @Provides
    fun api() = retrofitBuilder().create(RecipeApi::class.java)

}
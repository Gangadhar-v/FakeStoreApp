package com.example.fakestoreapp.di

import com.example.fakestoreapp.retrofit.RetrofitService
import com.example.fakestoreapp.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton


@Module
class NetworkModule {

    @Provides
    @Singleton
    fun retrofitInstance():Retrofit{
       return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofitService(retrofit:Retrofit):RetrofitService{
        return retrofit.create(RetrofitService::class.java)
    }
}

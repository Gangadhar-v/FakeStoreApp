package com.example.fakestoreapp.retrofit

import com.example.fakestoreapp.model.Product
import com.example.fakestoreapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET


interface RetrofitService {

    @GET(Constants.END_POINT)
    suspend fun getProducts(): Response<List<Product>>
}
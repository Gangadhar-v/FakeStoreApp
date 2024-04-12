package com.example.fakestoreapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fakestoreapp.model.Product
import com.example.fakestoreapp.retrofit.RetrofitService
import javax.inject.Inject

class ProductRepository @Inject constructor(private val retrofitService: RetrofitService) {

    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>>
        get() = _products

    suspend fun getProducts(){
        val result = retrofitService.getProducts()
        if(result.isSuccessful && result.body() != null){
            _products.postValue(result.body())
        }
    }
}
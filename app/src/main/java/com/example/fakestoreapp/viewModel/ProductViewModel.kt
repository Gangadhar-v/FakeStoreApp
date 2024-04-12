package com.example.fakestoreapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestoreapp.model.Product
import com.example.fakestoreapp.repository.ProductRepository
import kotlinx.coroutines.launch

class ProductViewModel(val productRepository: ProductRepository): ViewModel() {

    val productsLiveData: LiveData<List<Product>>
        get()=productRepository.products
    init{
        viewModelScope.launch {
            productRepository.getProducts()
        }
    }
}
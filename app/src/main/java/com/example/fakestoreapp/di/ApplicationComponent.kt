package com.example.fakestoreapp.di

import androidx.fragment.app.Fragment
import com.example.fakestoreapp.ProductsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules =[NetworkModule::class])
interface ApplicationComponent {

    fun inject(productsFragment: ProductsFragment)
}
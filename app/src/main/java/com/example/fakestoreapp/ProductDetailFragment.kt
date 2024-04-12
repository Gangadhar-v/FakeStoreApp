package com.example.fakestoreapp

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fakestoreapp.databinding.FragmentProductDetailBinding
import com.example.fakestoreapp.model.Product
import com.google.gson.Gson


class ProductDetailFragment : Fragment() {

    lateinit var binding: FragmentProductDetailBinding
    var product: Product? = null



    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        product = arguments?.getParcelable("product", Product::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProductDetailBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.img_1)
        product?.let {
            Glide.with(this)
                .load(it.image)
                .apply(requestOptions)
                .into(binding.image)

            binding.apply{
                titleTv.text = it.title
                descriptionTv.text = it.description
                productcosttv.text = it.price.toString()
                productratingtv.text = it.rating?.rate.toString()
                backbtn.setOnClickListener {
                    it.findNavController().navigate(R.id.action_productDetailFragment_to_productsFragment)
                }
            }
        }
    }
}
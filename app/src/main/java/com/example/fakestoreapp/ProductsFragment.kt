package com.example.fakestoreapp

import android.os.Build
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestoreapp.databinding.FragmentProductsBinding
import com.example.fakestoreapp.model.Product
import com.example.fakestoreapp.viewModel.ProductViewModel
import com.example.fakestoreapp.viewModel.ProductViewModelFactory
import javax.inject.Inject


class ProductsFragment : Fragment() {
    lateinit var productViewModel: ProductViewModel
    lateinit var binding: FragmentProductsBinding
    lateinit var productAdapter:ProductAdapter
    lateinit var recyclerView: RecyclerView


    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        (requireActivity().application as FakerApplication).applicationComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        productViewModel = ViewModelProvider(this,productViewModelFactory).get(ProductViewModel::class.java)
        binding = FragmentProductsBinding.inflate(inflater,container,false)
        recyclerView = binding.recyclerView
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        productViewModel.productsLiveData.observe(viewLifecycleOwner, Observer {
            productAdapter = ProductAdapter(requireContext(),it)
            recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
            recyclerView.adapter = productAdapter

        })
    }
}
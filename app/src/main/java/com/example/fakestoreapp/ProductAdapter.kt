package com.example.fakestoreapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.fakestoreapp.model.Product
import com.google.gson.Gson

class ProductAdapter(val context: Context, val products:List<Product>):Adapter<ProductAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(item: View):ViewHolder(item){
        val image = item.findViewById<ImageView>(R.id.product_image)
        val title = item.findViewById<TextView>(R.id.product_titletv)
        val cost = item.findViewById<TextView>(R.id.product_costtv)
        val rating = item.findViewById<TextView>(R.id.product_ratingtv)
        val category = item.findViewById<TextView>(R.id.categorytv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val item = LayoutInflater.from(context).inflate(R.layout.product,parent,false)
        return ProductViewHolder(item)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        val price = product.price
        holder.title.text = product.title
        holder.category.text = product.category
        holder.cost.text = String.format("Rs %.4f",price)
        holder.rating.text = product.rating?.rate.toString()

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.img_1)
        Glide.with(context)
            .load(product.image)
            .apply(requestOptions)
            .into(holder.image)


        holder.itemView.setOnClickListener {
            val bundle = Bundle()
            bundle.putParcelable("product",product)

            it.findNavController().navigate(resId = R.id.action_productsFragment_to_productDetailFragment,bundle)
        }
    }
}
package com.example.fakestoreapp.model

import android.os.Parcel
import android.os.Parcelable


data class Product(
    val category: String?,
    val description: String?,
    val id: Int,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readDouble(),
        parcel.readParcelable(Rating::class.java.classLoader),
        parcel.readString()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}
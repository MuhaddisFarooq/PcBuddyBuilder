package com.example.pcbuddybuilder

data class Category(val name: String)

data class Product(
    val name: String,
    val price: String,
    val rating: Float,
    val imageResId: Int,
    val quantity: Int,
    val categoryName: String,
    val vendorName: String,
    val description: String,
    val companyName: String

)



data class CartItem(
    val id: String,
    val name: String,
    val price: Double,
    val quantity: Int,
    val imageResId: Int
)



data class Vendor(
    val name: String,
    val imageResId: Int,
    val location:String,
    val status:Int
)

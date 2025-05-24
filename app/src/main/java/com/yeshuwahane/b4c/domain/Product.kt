package com.yeshuwahane.b4c.domain




data class Product(
    val productName: String,
    val description: String,
    val price: String,
    val oldPrice: String,
    val rating: Int,
    val reviews: Int,
    val imageRes: Int,
    val tagText: String = "Best seller",
    val inStock: Boolean = true
)

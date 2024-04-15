package com.example.pcbuddybuilder

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PopularProductAdapter(private val products: List<Product>) : RecyclerView.Adapter<PopularProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val productNameTextView: TextView = view.findViewById(R.id.product_name)
        private val productPriceTextView: TextView = view.findViewById(R.id.product_price)
        private val productRatingBar: RatingBar = view.findViewById(R.id.product_rating)
        private val productImageView: ImageView = view.findViewById(R.id.product_image)
        private val vendorNameTextView: TextView = view.findViewById(R.id.vendor_name)
        private val companyTextView: TextView = view.findViewById(R.id.Companyname)


        fun bind(product: Product) {
            productNameTextView.text = product.name
            productPriceTextView.text = product.price
            productRatingBar.rating = product.rating
            productImageView.setImageResource(product.imageResId)
            vendorNameTextView.text = product.vendorName
            companyTextView.text = product.companyName

            // Set onClickListener to launch DetailsActivity with product details
            itemView.setOnClickListener {
                val context = it.context
                val intent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra("productName", product.name)
                    putExtra("productPrice", product.price)
                    putExtra("productRating", product.rating)
                    putExtra("productImage", product.imageResId)
                    putExtra("productVendor", product.vendorName)
                    putExtra("productDescription", product.description)
                    putExtra("CompanyName", product.companyName)

                }
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
    }

    override fun getItemCount() = products.size
}

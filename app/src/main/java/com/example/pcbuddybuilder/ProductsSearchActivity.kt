// ProductsSearchActivity.kt
package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ProductsSearchActivity : AppCompatActivity() {

    private val pcBuilderApp: PcBuilderApp
        get() = application as PcBuilderApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_search)

        val company = intent.getStringExtra("company")
        if (company != null) {
            val filteredProducts = getFilteredProducts(company)
            val recyclerView: RecyclerView = findViewById(R.id.rvProducts)
            recyclerView.layoutManager = GridLayoutManager(this,2)
            recyclerView.adapter = PopularProductAdapter(filteredProducts)
        } else {
            Log.d("ProductsSearchActivity", "No company provided in intent")
        }

        //for back naviagtion
        val backButton: ImageView = findViewById(R.id.backarrow)
        backButton.setOnClickListener {
            // Navigate back to MenuActivity
            val intent = Intent(this, MenuActivity::class.java)
            // Consider using the FLAG_ACTIVITY_CLEAR_TOP to clear the activity stack
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish() // Finish this activity
        }
    }

    private fun getFilteredProducts(company: String): List<Product> {
        // Replace with the actual list of products
        return pcBuilderApp.allProducts.filter {
            it.companyName.equals(company, ignoreCase = true)
        }
    }
}

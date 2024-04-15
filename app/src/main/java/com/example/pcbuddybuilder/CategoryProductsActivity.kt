package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pcbuddybuilder.databinding.ActivityCategoryProductsBinding

class CategoryProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCategoryProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the global list of all products from the application class
        val allProducts = (application as PcBuilderApp).allProducts

        val categoryName = intent.getStringExtra("category_name") ?: return
        binding.tvCategoryTitle.text = categoryName

        // Filter products for the given category
        val filteredProducts = allProducts.filter { it.categoryName == categoryName }
        setupRecyclerView(filteredProducts)

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

    private fun setupRecyclerView(products: List<Product>) {
        val productAdapter = PopularProductAdapter(products)
        binding.rvCategoryProducts.layoutManager = GridLayoutManager(this, 2)
        binding.rvCategoryProducts.adapter = productAdapter
    }

}

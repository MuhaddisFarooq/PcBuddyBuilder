package com.example.pcbuddybuilder


import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pcbuddybuilder.databinding.ActivityMenuBinding



class MenuActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMenuBinding

    // Hardcoded data for categories and products
    private val categories = listOf(
        Category("Processors"),
        Category("GPU"),
        Category("Motherboards"),
        Category("Laptops"),
        Category("Accessories")

    )



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val allProducts = (application as PcBuilderApp).allProducts

        setupCategoryRecyclerView()
        setupPopularProductsRecyclerView(allProducts)
        setupDealsSlider()
        setupBottomNavigationView()
        GoToBuildPC()
        GoToNotification()
        setupSearchBar()

    }

    private fun setupCategoryRecyclerView() {
        val categoryAdapter = CategoryAdapter(categories) { category ->
            val intent = Intent(this, CategoryProductsActivity::class.java).apply {
                putExtra("category_name", category.name)
            }
            startActivity(intent)
        }
        binding.rvCategories.apply {
            layoutManager = LinearLayoutManager(this@MenuActivity, RecyclerView.HORIZONTAL, false)
            adapter = categoryAdapter
        }
    }


    private fun setupPopularProductsRecyclerView(products: List<Product>) {
        val popularProductAdapter = PopularProductAdapter(products)
        binding.rvPopularProducts.apply {
            layoutManager = GridLayoutManager(this@MenuActivity, 2)
            adapter = popularProductAdapter
        }
    }


    private fun setupDealsSlider() {
        val images = listOf(R.drawable.deal1, R.drawable.deal2, R.drawable.deal3)
        val adapter = DealsSliderAdapter(images)
        binding.vpDealsSlider.adapter = adapter
    }


    private fun setupBottomNavigationView() {
        binding.bottomNavigation.selectedItemId = R.id.navigation_home
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle the home action
                    true
                }

                R.id.navigation_cart -> {
                    // Handle the cart action
                    val cart = Intent(this, CartActivity::class.java)
                    startActivity(cart)
                    finish()
                    true
                }

                R.id.add_products -> {
                    // Handle the add products action
                    val add = Intent(this, AddProductsActivity::class.java)
                    startActivity(add)
                    finish()
                    true
                }

                R.id.navigation_chat -> {
                    // Handle the chat action
                    val chat = Intent(this, ChatActivity::class.java)
                    startActivity(chat)
                    finish()
                    true
                }

                R.id.navigation_profile -> {
                    // Handle the profile action
                    val profile = Intent(this, UserProfileActivity::class.java)
                    startActivity(profile)
                    finish()
                    true
                }

                else -> false
            }
        }
    }


    private fun GoToBuildPC() {

        val buildPC = findViewById<Button>(R.id.btnUploadPhoto)
        buildPC.setOnClickListener {
            val pc = Intent(this, BuildCustomPcActivity::class.java)
            startActivity(pc)
            finish()
        }


    }

    private fun GoToNotification() {

        val not = findViewById<ImageView>(R.id.notification_bell)
        not.setOnClickListener {
            val pc = Intent(this, NotificationActivity::class.java)
            startActivity(pc)
            finish()
        }


    }


    private fun setupSearchBar() {
        val searchBar: EditText = findViewById(R.id.search_bar)
        searchBar.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(v.text.toString())
                true
            } else false
        }
    }

    private fun performSearch(query: String) {
        if (query.isNotEmpty()) {
            val intent = Intent(this, ProductsSearchActivity::class.java).apply {
                putExtra("company", query.trim())
            }
            startActivity(intent)
        }
    }




}







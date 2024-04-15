package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pcbuddybuilder.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var cartAdapter: CartItemAdapter
    // Declare cartItems as a MutableList to allow modifications
    private val cartItems = mutableListOf(
        CartItem("id1", "PC", 48.00, 2, R.drawable.pc1),
        CartItem("id2", "Computer", 30.00, 1, R.drawable.c4),
        // Add more items as necessary
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        displayOrderSummary()
        setupListeners()
        setupBottomNavigationView()
        backMove()
    }

    private fun setupRecyclerView() {
        cartAdapter = CartItemAdapter(cartItems) { cartItem, change ->
            // Find the index of the item you want to update
            val index = cartItems.indexOfFirst { it.id == cartItem.id }
            if (index != -1) {
                // Safely modify the item quantity within the mutable list
                cartItems[index] = cartItems[index].copy(quantity = cartItems[index].quantity + change)
                cartAdapter.notifyItemChanged(index)

                // Recalculate totals and update UI
                displayOrderSummary()
            }
        }
        binding.cartview.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            adapter = cartAdapter
        }
    }

    private fun displayOrderSummary() {
        // Example calculation for subtotal and other totals
        val subtotal = cartItems.sumOf { it.price * it.quantity }
        val deliveryFee = 10.00  // Example fixed delivery fee
        val tax = subtotal * 0.08  // Example tax rate of 8%
        val total = subtotal + deliveryFee + tax

        // Update UI components with calculated values
        binding.textView6.text = String.format("$%.2f", subtotal)
        binding.textView8.text = String.format("$%.2f", deliveryFee)
        binding.textView11.text = String.format("$%.2f", tax)
        binding.textView13.text = String.format("$%.2f", total)
    }

    private fun setupListeners() {
        binding.buttonorder.setOnClickListener {
            // Implement checkout or order placement logic here
        }
    }


    private fun backMove(){

        binding.backbtn.setOnClickListener {
            val bkt = Intent(this, MenuActivity::class.java)
            startActivity(bkt)
            finish()
        }

    }

    private fun setupBottomNavigationView() {
        binding.bottomNavigation.selectedItemId = R.id.navigation_cart
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    // Handle the home action
                    val home = Intent(this,MenuActivity::class.java)
                    startActivity(home)
                    finish()
                    true
                }
                R.id.navigation_cart -> {
                    // Handle the cart action
                    true
                }

                R.id.add_products -> {
                    // Handle the add products action
                    val add = Intent(this,AddProductsActivity::class.java)
                    startActivity((add))
                    finish()
                    true
                }

                R.id.navigation_chat -> {
                    // Handle the chat action
                    true
                }
                R.id.navigation_profile -> {
                    // Handle the profile action
                    val profile = Intent(this,UserProfileActivity::class.java)
                    startActivity(profile)
                    finish()
                    true
                }
                else -> false
            }
        }
    }


}

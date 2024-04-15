package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pcbuddybuilder.databinding.ActivityAddProductsBinding

class AddProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddProductsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupListeners()
        setupBottomNavigationView()
        backMove()
    }

    private fun setupListeners() {
        binding.buttonorder.setOnClickListener {
            if (validateInput()) {
                addProductToInventory()
            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnUploadPhoto.setOnClickListener {
            // Implement photo upload logic here
        }

        binding.ivBack.setOnClickListener {
            finish()  // Close the activity
        }
    }

    private fun validateInput(): Boolean {
        // Check if any input is empty
        return binding.etMentorName.text.isNotEmpty() &&
                binding.etDescription.text.isNotEmpty() &&
                binding.etPrice.text.isNotEmpty() &&
                binding.qty.text.isNotEmpty() &&
                binding.vendor.text.isNotEmpty()
    }

    private fun addProductToInventory() {
        // You would normally handle database interactions or API calls here
        // For example:
        val name = binding.etMentorName.text.toString()
        val description = binding.etDescription.text.toString()
        val price = binding.etPrice.text.toString().toDouble()
        val quantity = binding.qty.text.toString().toInt()
        val vendor = binding.vendor.text.toString()

        // Simulating adding the product to a database or server
        Toast.makeText(this, "Product Added: $name", Toast.LENGTH_LONG).show()

        // Optionally clear the fields after adding
        clearFields()
    }

    private fun clearFields() {
        binding.etMentorName.setText("")
        binding.etDescription.setText("")
        binding.etPrice.setText("")
        binding.qty.setText("")
        binding.vendor.setText("")
    }


    private fun backMove(){

        binding.ivBack.setOnClickListener {
            val bkt = Intent(this, MenuActivity::class.java)
            startActivity(bkt)
            finish()
        }

    }


    private fun setupBottomNavigationView() {
       binding.bottomNavigationView.selectedItemId = R.id.add_products
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
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
                    val cart = Intent(this,CartActivity::class.java)
                    startActivity((cart))
                    finish()
                    true
                }

                R.id.add_products -> {
                    // Handle the add products action
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

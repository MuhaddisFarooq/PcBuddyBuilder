package com.example.pcbuddybuilder

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class BuildCustomPcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_custom_pc)

        setupSpinner(findViewById(R.id.spinnerProcessor), listOf("Intel i9", "AMD Ryzen 9"))
        setupSpinner(findViewById(R.id.spinnerMonitor), listOf("ASUS 144 HZ", "DELL 60 HZ"))
        setupSpinner(findViewById(R.id.spinnerGPU), listOf("RTX 4080TI", "GTX 1050TI"))
        setupSpinner(findViewById(R.id.spinnerMotherboard), listOf("MSI", "ASUS"))
        setupSpinner(findViewById(R.id.spinnerRAM), listOf("8GB", "16GB"))

        //for back naviagtion
        val backButton: ImageView = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            // Navigate back to MenuActivity
            val intent = Intent(this, MenuActivity::class.java)
            // Consider using the FLAG_ACTIVITY_CLEAR_TOP to clear the activity stack
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish() // Finish this activity
        }



        // Set up bottom navigation
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val home = Intent(this,MenuActivity::class.java)
                    startActivity(home)
                    finish()
                    true
                }

                R.id.navigation_cart -> {
                    // Handle the cart action
                    val cart = Intent(this,CartActivity::class.java)
                    startActivity(cart)
                    finish()
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
                // Handle other menu item clicks here
                else -> false
            }
        }

    }




    private fun setupSpinner(spinner: Spinner, items: List<String>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }



    }






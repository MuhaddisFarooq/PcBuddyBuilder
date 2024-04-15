package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityIndividualChat : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_chat)

        val userNameTextView: TextView = findViewById(R.id.tvChatName)
        // Get the vendor name passed from ChatActivity
        val vendorName = intent.getStringExtra("vendorName") ?: "Vendor"
        userNameTextView.text = vendorName



        //for back naviagtion
        val backButton: ImageView = findViewById(R.id.ivBack)
        backButton.setOnClickListener {
            // Navigate back to MenuActivity
            val intent = Intent(this, ChatActivity::class.java)
            // Consider using the FLAG_ACTIVITY_CLEAR_TOP to clear the activity stack
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish() // Finish this activity
        }


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView.selectedItemId = R.id.navigation_chat
        bottomNavigationView.menu.findItem(R.id.navigation_chat).isChecked = true
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val home = Intent(this, MenuActivity::class.java)
                    startActivity(home)
                    finish()
                    true
                }
                R.id.navigation_cart -> {
                    val cart = Intent(this, CartActivity::class.java)
                    startActivity(cart)
                    finish()
                    true
                }
                R.id.add_products -> {
                    val add = Intent(this, AddProductsActivity::class.java)
                    startActivity(add)
                    finish()
                    true
                }
                R.id.navigation_chat -> {
                    // Already in ChatActivity, no need to reload
                    true
                }
                R.id.navigation_profile -> {
                    val profile = Intent(this, UserProfileActivity::class.java)
                    startActivity(profile)
                    finish()
                    true
                }
                else -> false
            }
        }




    }








}

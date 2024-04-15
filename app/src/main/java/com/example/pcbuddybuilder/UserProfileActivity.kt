package com.example.pcbuddybuilder


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val emailTextView: TextView = findViewById(R.id.emailLabel)
        val contactTextView: TextView = findViewById(R.id.ContactLabel)
        val countryTextView: TextView = findViewById(R.id.CountryLabel)
        val roleTextView: TextView = findViewById(R.id.roleLabel)

        // Hardcoded user details
        val userEmail = "ali@gmail.com"
        val userContact = "+123456789"
        val userCountry = "Pakistan"
        val userRole = "Vendor"

        // Setting the hardcoded details to the TextViews
        emailTextView.text = userEmail
        contactTextView.text = userContact
        countryTextView.text = userCountry
        roleTextView.text = userRole


        val backButton: ImageView = findViewById(R.id.backarrow)
        backButton.setOnClickListener {
            val home = Intent(this,MenuActivity::class.java)
            startActivity(home)
            finish()        }

        val not: Button = findViewById(R.id.notificationButton)
        not.setOnClickListener {
            val notification = Intent(this,NotificationActivity::class.java)
            startActivity(notification)
            finish()        }

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.navigation_profile
        bottomNavigationView.menu.findItem(R.id.navigation_profile).isChecked = true
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
                    val chat = Intent(this,ChatActivity::class.java)
                    startActivity((chat))
                    finish()
                    true
                }
                R.id.navigation_profile -> {
                    true
                }
                // Handle other menu item clicks here
                else -> false
            }
        }


        setupButtonInteractions()
    }

    private fun setupButtonInteractions() {
        // Similarly, set up the 'edit profile' button
        val editProfileButton: Button = findViewById(R.id.editprofile)
        editProfileButton.setOnClickListener {
            val edit = Intent(this,EditProfileActivity::class.java)
            startActivity(edit)
            finish()
        }
    }
}

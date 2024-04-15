package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ChatActivity : AppCompatActivity() {
    private lateinit var vendorAdapter: VendorAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val vendors = listOf(
            Vendor("Ali", R.mipmap.profile_round,"Pakistan",R.mipmap.greendot_round),
            Vendor("Ahmad", R.mipmap.profile_round,"USA",R.mipmap.greendot_round),
            Vendor("Amjad", R.mipmap.profile_round,"Dubai",R.mipmap.reddot_round),
            Vendor("Salman", R.mipmap.profile_round,"Ireland",R.mipmap.reddot_round),
            Vendor("Osama", R.mipmap.profile_round,"Palestine",R.mipmap.greendot_round),
            Vendor("Jack", R.mipmap.profile_round,"Qatar",R.mipmap.greendot_round)

        )

        recyclerView = findViewById(R.id.rvVendors)
        recyclerView.layoutManager = LinearLayoutManager(this)
        vendorAdapter = VendorAdapter(vendors, this)
        recyclerView.adapter = vendorAdapter






        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)
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

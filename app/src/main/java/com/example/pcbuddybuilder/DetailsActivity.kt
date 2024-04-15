package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_product)

        val productName = intent.getStringExtra("productName")
        val productPrice = intent.getStringExtra("productPrice")
        val productRating = intent.getFloatExtra("productRating", 0f)
        val productImage = intent.getIntExtra("productImage", 0)
        val productVendor = intent.getStringExtra("productVendor")
        val productDescription = intent.getStringExtra("productDescription")


        // Assuming you have TextViews and an ImageView to set these
        findViewById<TextView>(R.id.product_name).text = productName
        findViewById<TextView>(R.id.price).text = productPrice
        findViewById<RatingBar>(R.id.product_rating).rating = productRating
        findViewById<ImageView>(R.id.product_image).setImageResource(productImage)
        findViewById<TextView>(R.id.vendor_name).text = productVendor
        findViewById<TextView>(R.id.des).text = productDescription


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

    }




}

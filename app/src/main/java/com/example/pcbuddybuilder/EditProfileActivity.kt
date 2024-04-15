package com.example.pcbuddybuilder


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        // Initialize views
        val ivBackArrow: ImageView = findViewById(R.id.ivBackArrow)
        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextContact: EditText = findViewById(R.id.editTextContact)
        val spinnerCountry: Spinner = findViewById(R.id.spinnerCountry)
        val buttonConfirm: Button = findViewById(R.id.editprofile)

        // Populate the spinner with country names
        val countries = arrayOf("Pakistan", "USA", "Germany")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerCountry.adapter = spinnerAdapter

        // Set up back arrow click listener
        ivBackArrow.setOnClickListener {
            // Simply finish the current activity to return to the previous activity
            val backArrow = Intent(this,UserProfileActivity::class.java)
            startActivity(backArrow)
            finish()
        }
        // Set up confirm button click listener
        buttonConfirm.setOnClickListener {
            // Handle the confirm action
            saveProfile()
        }
    }

    private fun saveProfile() {

    }
}

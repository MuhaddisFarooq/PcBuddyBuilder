package com.example.pcbuddybuilder


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val editTextName: EditText = findViewById(R.id.editTextName)
        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextContact: EditText = findViewById(R.id.editTextContact)
        val editTextCountry: EditText = findViewById(R.id.editTextCountry)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val buttonSignUp: Button = findViewById(R.id.buttonSignUp)
        val loginlink:TextView = findViewById(R.id.textViewLogin)

        buttonSignUp.setOnClickListener {
            val name = editTextName.text.toString()
            val email = editTextEmail.text.toString()
            val contact = editTextContact.text.toString()
            val country = editTextCountry.text.toString()
            val password = editTextPassword.text.toString()


        }

        loginlink.setOnClickListener{
            val loginlink = Intent(this,LoginActivity::class.java)
            startActivity((loginlink))
            finish()
        }


        val spinnerRoles = findViewById<Spinner>(R.id.Role)

        val roles = arrayOf("Admin", "Vendor", "Customer")

        val adapter = ArrayAdapter(this, R.layout.my_simple_spinner_item, roles)

        adapter.setDropDownViewResource(R.layout.my_simple_spinner_item)

        spinnerRoles.adapter = adapter

    }


    }



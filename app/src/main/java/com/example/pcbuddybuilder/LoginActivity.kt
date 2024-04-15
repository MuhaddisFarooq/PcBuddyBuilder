package com.example.pcbuddybuilder

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextEmail: EditText = findViewById(R.id.editTextEmail)
        val editTextPassword: EditText = findViewById(R.id.editTextPassword)
        val buttonLogin: Button = findViewById(R.id.buttonLogin)
        val registerlink: TextView = findViewById(R.id.textViewRegister)
        val buttonReset: TextView = findViewById(R.id.forgotPasswordTextView)



        buttonLogin.setOnClickListener {
            val btn= Intent(this,MenuActivity::class.java)
            startActivity(btn)
            finish()

        }

        registerlink.setOnClickListener {

            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
            finish()

        }

        buttonReset.setOnClickListener{

            val intent = Intent(this,FORGOTPasswordActivity::class.java)
            startActivity(intent)
            finish()

        }


        val spinnerRoles = findViewById<Spinner>(R.id.Role)

        val roles = arrayOf("Admin", "Vendor", "Customer")

        val adapter = ArrayAdapter(this, R.layout.my_simple_spinner_item, roles)
        adapter.setDropDownViewResource(R.layout.my_simple_spinner_item)
        spinnerRoles.adapter = adapter


    }
}

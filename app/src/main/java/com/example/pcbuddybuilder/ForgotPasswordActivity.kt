package com.example.pcbuddybuilder


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FORGOTPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val backArrow = findViewById<ImageView>(R.id.backArrow)
        val newPasswordEditText = findViewById<EditText>(R.id.newPasswordEditText)
        val confirmNewPasswordEditText = findViewById<EditText>(R.id.confirmNewPasswordEditText)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val resetTextView = findViewById<TextView>(R.id.resetTextview)

        backArrow.setOnClickListener {
            finish() // This will close the current activity and go back
        }

        resetButton.setOnClickListener {
            val newPassword = newPasswordEditText.text.toString()
            val confirmNewPassword = confirmNewPasswordEditText.text.toString()

            if (validatePasswords(newPassword, confirmNewPassword)) {
                resetPassword(newPassword) // Call your method to reset the password here
            } else {
                // Show error message to the user
            }
        }

        resetTextView.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun validatePasswords(newPassword: String, confirmNewPassword: String): Boolean {
        // Add your validation logic here and return true if the passwords are valid
        return newPassword.isNotEmpty() && newPassword == confirmNewPassword
    }

    private fun resetPassword(newPassword: String) {
        // Add your logic to handle password reset
    }
}

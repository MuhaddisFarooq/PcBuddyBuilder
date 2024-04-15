package com.example.pcbuddybuilder


import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class NotificationActivity : AppCompatActivity() {
    private lateinit var listView: ListView
    private lateinit var clearAllTextView: TextView
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        listView = findViewById(R.id.lvNotifications)
        clearAllTextView = findViewById(R.id.tvClearAll)
        val backArrow: ImageView = findViewById(R.id.ivBackArrow)

        // Sample data for notifications
        val notifications = arrayListOf("Notification 1", "Notification 2", "Notification 3")

        // Setting up the adapter
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, notifications)
        listView.adapter = adapter

        // Clear all notifications
        clearAllTextView.setOnClickListener {
            clearNotifications()
        }

        // Back navigation
        backArrow.setOnClickListener {
            val home = Intent(this,MenuActivity::class.java)
            startActivity(home)
            finish()
        }
    }

    private fun clearNotifications() {
        adapter.clear()
        adapter.notifyDataSetChanged() // Notify the adapter to refresh the list
    }
}

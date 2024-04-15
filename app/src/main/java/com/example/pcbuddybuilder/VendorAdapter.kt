package com.example.pcbuddybuilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import android.content.Context
import android.content.Intent


class VendorAdapter(private val vendors: List<Vendor>, private val context: Context) : RecyclerView.Adapter<VendorAdapter.VendorViewHolder>() {

    class VendorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val vendorImage: ImageView = view.findViewById(R.id.ivVendor)
        val vendorName: TextView = view.findViewById(R.id.tvVendorName)
        val vendorCountry: TextView = view.findViewById(R.id.tvVendorLocation) // Assuming you have a TextView for country
        val vendorStatus: ImageView = view.findViewById(R.id.ivStatus) // Status ImageView

        fun bind(vendor: Vendor, clickListener: (Vendor) -> Unit) {
            vendorName.text = vendor.name
            vendorImage.setImageResource(vendor.imageResId)
            vendorCountry.text = vendor.location
            vendorStatus.setImageResource(vendor.status) // Show online/offline status

            itemView.setOnClickListener { clickListener(vendor) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VendorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vendor, parent, false)
        return VendorViewHolder(view)
    }

    override fun onBindViewHolder(holder: VendorViewHolder, position: Int) {
        holder.bind(vendors[position]) { vendor ->
            // Define what happens when a vendor is clicked
            val intent = Intent(context, ActivityIndividualChat::class.java)
            intent.putExtra("vendorName", vendor.name)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = vendors.size
}

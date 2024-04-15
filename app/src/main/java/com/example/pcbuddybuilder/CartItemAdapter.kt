package com.example.pcbuddybuilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pcbuddybuilder.databinding.ItemCartBinding

class CartItemAdapter(private val cartItems: MutableList<CartItem>,
                      private val onQuantityChanged: (CartItem, Int) -> Unit) :
    RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    class CartItemViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val binding = ItemCartBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CartItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem = cartItems[position]
        holder.binding.apply {
            tvCartItemName.text = cartItem.name
            tvCartItemPrice.text = String.format("$%.2f", cartItem.price)
            tvQuantity.text = cartItem.quantity.toString()
            ivCartItem.setImageResource(cartItem.imageResId)

            btnIncreaseQuantity.setOnClickListener {
                onQuantityChanged(cartItem, 1)
            }

            btnDecreaseQuantity.setOnClickListener {
                if (cartItem.quantity > 1) {
                    onQuantityChanged(cartItem, -1)
                }
            }
        }
    }

    override fun getItemCount() = cartItems.size
}

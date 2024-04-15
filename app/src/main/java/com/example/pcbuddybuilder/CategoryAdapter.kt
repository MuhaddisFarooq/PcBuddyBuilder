package com.example.pcbuddybuilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoryAdapter(private val categories: List<Category>, private val onClick: (Category) -> Unit) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    class CategoryViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(category: Category) {
            view.findViewById<TextView>(R.id.category_name).text = category.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.bind(category)
        holder.itemView.setOnClickListener {
            onClick(category)
        }
    }

    override fun getItemCount() = categories.size
}
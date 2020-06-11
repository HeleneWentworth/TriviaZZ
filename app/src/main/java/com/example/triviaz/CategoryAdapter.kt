package com.example.triviaz

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_item.view.*


class CategoryAdapter(private val categoryList: List<CategoryItem>) :RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val currentItem = categoryList[position]
        holder.textView.text = currentItem.text
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView : TextView = itemView.category_text
    }

}
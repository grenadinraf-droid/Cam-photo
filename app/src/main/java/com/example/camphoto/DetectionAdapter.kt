package com.example.camphoto

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class DetectionResult(val text: String, val image: Bitmap)

class DetectionAdapter(private val items: MutableList<DetectionResult>) :
    RecyclerView.Adapter<DetectionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.itemText)
        val imageView: ImageView = view.findViewById(R.id.itemImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_detection, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textView.text = item.text
        holder.imageView.setImageBitmap(item.image)
    }

    override fun getItemCount() = items.size

    fun addItem(item: DetectionResult) {
        items.add(0, item)
        notifyItemInserted(0)
    }
}

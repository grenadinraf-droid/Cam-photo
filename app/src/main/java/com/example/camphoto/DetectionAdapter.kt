package com.example.camphoto

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.Locale

data class DetectionResult(
    val plateNumber: String,
    val originalImage: Bitmap,
    val timestamp: Long = System.currentTimeMillis()
)

class DetectionAdapter(private val items: MutableList<DetectionResult>) :
    RecyclerView.Adapter<DetectionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgPhoto: ImageView = view.findViewById(android.R.id.icon)
        val textPlate: TextView = view.findViewById(android.R.id.text1)
        val textTime: TextView = view.findViewById(android.R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(android.R.layout.activity_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.textPlate.text = "Номер: ${item.plateNumber}"
        val sdf = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
        holder.textTime.text = "Время: ${sdf.format(item.timestamp)}"
        holder.imgPhoto.setImageBitmap(item.originalImage)
    }

    override fun getItemCount() = items.size

    fun addItem(newItem: DetectionResult) {
        items.add(0, newItem)
        notifyItemInserted(0)
    }
}

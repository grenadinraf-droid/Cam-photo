package com.example.camphoto

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class PlateAdapter(private val plates: List<PlateEntity>) :
    RecyclerView.Adapter<PlateAdapter.PlateViewHolder>() {

    class PlateViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivCarPhoto: ImageView = view.findViewById(R.id.ivCarPhoto)
        val tvPlateNumber: TextView = view.findViewById(R.id.tvPlateNumber)
        val tvTimestamp: TextView = view.findViewById(R.id.tvTimestamp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_plate, parent, false)
        return PlateViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        val item = plates[position]
        holder.tvPlateNumber.text = item.plateNumber

        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        holder.tvTimestamp.text = sdf.format(Date(item.timestamp))

        if (item.imagePath.isNotEmpty() && File(item.imagePath).exists()) {
            val bitmap = BitmapFactory.decodeFile(item.imagePath)
            holder.ivCarPhoto.setImageBitmap(bitmap)
        } else {
            holder.ivCarPhoto.setImageResource(android.R.drawable.ic_menu_camera)
        }
    }

    override fun getItemCount() = plates.size
}

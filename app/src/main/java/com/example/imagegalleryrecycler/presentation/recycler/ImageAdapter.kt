package com.example.imagegalleryrecycler.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.imagegalleryrecycler.presentation.data.ImageUri

class ImageAdapter(
    getImageUri: ImageUri,
) : RecyclerView.Adapter<ImageViewHolder>() {

    private var items: List<String> = getImageUri.getImageUri()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder.fromParent(parent)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bindView(position, items)
    }

    override fun getItemCount() = items.size
}
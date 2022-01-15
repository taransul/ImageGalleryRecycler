package com.example.imagegalleryrecycler.presentation.recycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imagegalleryrecycler.R
import com.example.imagegalleryrecycler.presentation.Constants
import com.example.imagegalleryrecycler.presentation.activity.FullImageActivity
import kotlinx.android.synthetic.main.image_item_layout.view.*

class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        fun fromParent(parent: ViewGroup) =
            ImageViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.image_item_layout, parent, false)
            )
    }

    private val image by lazy { itemView.image }

    fun bindView(position: Int, imageUri: List<String>) {
        loadImageByUrl(imageUri[position])
    }

    private fun loadImageByUrl(url: String) {
        Glide.with(image.context)
            .load(url)
            .centerCrop()
            .placeholder(R.color.chocolate)
            .into(image)

        image.setOnClickListener {
            image.context.startActivity(Intent(image.context,
                FullImageActivity::class.java).putExtra(Constants.KEY_PUT_EXTRA, url))
        }
    }
}
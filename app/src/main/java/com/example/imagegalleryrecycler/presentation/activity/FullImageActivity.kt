package com.example.imagegalleryrecycler.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.imagegalleryrecycler.R
import com.example.imagegalleryrecycler.presentation.Constants
import kotlinx.android.synthetic.main.activity_full_image.*

class FullImageActivity : AppCompatActivity(R.layout.activity_full_image) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Glide.with(this)
            .load(intent.getStringExtra(Constants.KEY_PUT_EXTRA))
            .placeholder(R.drawable.layout_bg)
            .into(image)

        back.setOnClickListener {
            finish()
        }
    }
}
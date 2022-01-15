package com.example.imagegalleryrecycler.presentation.activity

import android.Manifest
import android.content.pm.PackageManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagegalleryrecycler.R
import com.example.imagegalleryrecycler.presentation.Constants
import com.example.imagegalleryrecycler.presentation.data.ImageUri
import com.example.imagegalleryrecycler.presentation.recycler.ImageAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val adapter by lazy { ImageAdapter(ImageUri(this)) }

    override fun onResume() {
        super.onResume()

        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                Constants.PERMISSIONS_READ_EXTERNAL_STORAGE
            )
        } else {
            initRecycler()
        }
    }

    private fun initRecycler() {
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 3)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray,
    ) {
        if (requestCode == Constants.PERMISSIONS_READ_EXTERNAL_STORAGE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initRecycler()
            } else {
                Toast.makeText(this@MainActivity,
                    getString(R.string.permission_error),
                    Toast.LENGTH_SHORT)
                    .show()
            }
            return
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
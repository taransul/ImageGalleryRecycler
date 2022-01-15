package com.example.imagegalleryrecycler.presentation.data

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.example.imagegalleryrecycler.presentation.Image

class ImageUri(private val context: Context) : Image {

    override fun getImageUri(): List<String> {
        val imageList: MutableList<String> = mutableListOf()
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        var absolutePathOfImage: String
        val projection = arrayOf(
            MediaStore.MediaColumns.DATA,
            MediaStore.Images.Media.BUCKET_DISPLAY_NAME
        )
        val cursor: Cursor? =
            context.contentResolver.query(
                uri,
                projection,
                null,
                null,
                null
            )
        val columnIndexData: Int? = cursor?.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)
        while (cursor?.moveToNext() == true) {
            absolutePathOfImage = cursor.getString(columnIndexData!!)
            imageList.add(absolutePathOfImage)
        }
        return imageList
    }
}
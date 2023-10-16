package com.andrew.saba.photosmanger

import android.content.ContentUris
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.andrew.saba.photosmanger.adapter.ImageGalleryAdapter
import com.andrew.saba.photosmanger.databinding.ActivityMainBinding
import com.andrew.saba.photosmanger.model.GalleryPhoto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var imageGalleryAdapter:ImageGalleryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imagesGridRv.layoutManager=GridLayoutManager(this,3)
        val projection = arrayOf(MediaStore.Images.Media._ID)
        val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
        val imagePaths = ArrayList<String>()
        if (cursor != null) {
            while (cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                val path = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id).toString()
                imagePaths.add(path)
            }
            cursor.close()
        }

        imageGalleryAdapter= ImageGalleryAdapter(GalleryPhoto.getPhotos(imagePaths))
    }


    override fun onStart() {
        super.onStart()
        binding.imagesGridRv.adapter=imageGalleryAdapter

    }


}
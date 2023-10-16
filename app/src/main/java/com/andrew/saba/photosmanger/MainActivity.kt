package com.andrew.saba.photosmanger

import android.Manifest
import android.content.ContentUris
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.andrew.saba.photosmanger.adapter.ImageGalleryAdapter
import com.andrew.saba.photosmanger.databinding.ActivityMainBinding
import com.andrew.saba.photosmanger.model.GalleryPhoto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imagePaths = ArrayList<String>()
    private lateinit var imageGalleryAdapter:ImageGalleryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestPermissions()
        binding.cameraButton.setOnClickListener {
            val intent = Intent(this, CameraActivity::class.java)
            startActivity(intent)
        }
    }

    private val activityResultLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()) { permissions ->
            // Handle Permission granted/rejected
            var permissionGranted = true
            permissions.entries.forEach {
                if (it.key == Manifest.permission.READ_EXTERNAL_STORAGE && !it.value)
                    permissionGranted = false
            }
            if (!permissionGranted) {
                Toast.makeText(baseContext,
                    "Permission request denied",
                    Toast.LENGTH_SHORT).show()
            } else {
                binding.imagesGridRv.layoutManager= GridLayoutManager(this,3)
                val projection = arrayOf(MediaStore.Images.Media._ID)
                val cursor = contentResolver.query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, projection, null, null, null)
                if (cursor != null) {
                    while (cursor.moveToNext()) {
                        val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                        val path = ContentUris.withAppendedId(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, id).toString()
                        imagePaths.add(path)
                    }
                    cursor.close()
                }
                imageGalleryAdapter= ImageGalleryAdapter(GalleryPhoto.getPhotos(imagePaths))
                binding.imagesGridRv.adapter=imageGalleryAdapter
            }
        }

    private fun requestPermissions() {
        activityResultLauncher.launch(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE))
    }
}
package com.andrew.saba.photosmanger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.andrew.saba.photosmanger.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {
    private lateinit var binding:ActivityCameraBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
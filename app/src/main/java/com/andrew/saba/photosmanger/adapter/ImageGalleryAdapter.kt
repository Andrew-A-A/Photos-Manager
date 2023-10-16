package com.andrew.saba.photosmanger.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.andrew.saba.photosmanger.R
import com.andrew.saba.photosmanger.model.GalleryPhoto
import com.squareup.picasso.Picasso

class ImageGalleryAdapter(private val galleryPhotos: ArrayList<GalleryPhoto>)
    :RecyclerView.Adapter<MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context=parent.context
        val inflater = LayoutInflater.from(context)
        val photoView=inflater.inflate(R.layout.item_image,parent,false)
        return MyViewHolder(photoView)
    }

    override fun getItemCount(): Int {
        return galleryPhotos.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val galleryPhoto = galleryPhotos[position]
        val imageView = holder.photoImageView
        holder.imagePath= galleryPhotos[position].path.toString()
        Picasso.get()
            .load(galleryPhoto.path)
            .fit()
            .into(imageView)
    }

}
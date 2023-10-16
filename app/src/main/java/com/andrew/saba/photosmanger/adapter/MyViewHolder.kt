package com.andrew.saba.photosmanger.adapter

import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.andrew.saba.photosmanger.R

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
    lateinit var imagePath:String
    var photoImageView:ImageView=itemView.findViewById(R.id.imageView)
    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        if (p0 != null) {
            Toast.makeText(p0.context,"Image $imagePath tapped",Toast.LENGTH_SHORT).show()
        }
    }

}
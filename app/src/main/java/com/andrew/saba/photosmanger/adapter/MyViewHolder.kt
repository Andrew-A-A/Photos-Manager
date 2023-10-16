package com.andrew.saba.photosmanger.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.andrew.saba.photosmanger.R

class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener {
    var photoImageView:ImageView=itemView.findViewById(R.id.imageView)
    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {

    }

}
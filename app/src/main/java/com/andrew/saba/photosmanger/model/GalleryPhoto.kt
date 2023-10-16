package com.andrew.saba.photosmanger.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class GalleryPhoto(val path: String?) :Parcelable {
    companion object {
        fun getPhotos(paths: ArrayList<String>): ArrayList<GalleryPhoto>{
            val galleryPhotos=ArrayList<GalleryPhoto>()
            for(path in paths){
                galleryPhotos.add(GalleryPhoto(path))
            }
            return galleryPhotos
        }
    }
}
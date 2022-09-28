package com.example.mvvmretrofitdaggerkt.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

// DataBinding - ImageView:imageUrl
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    imageUrl?.let {
        Glide.with(view.context).load(it).into(view)
    }
}

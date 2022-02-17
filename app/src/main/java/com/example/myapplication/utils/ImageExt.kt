package com.example.myapplication.utils

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide
import com.example.myapplication.R

fun ImageView.bindImage(url: String? = null) {
    Glide.with(this)
        .load(url)
        .placeholder(R.drawable.img_placeholder)
        .into(this)
}

fun ImageView.bindImage(url: String? = null, @DrawableRes res: Int) {
    Glide.with(this)
        .load(url)
        .placeholder(res)
        .into(this)
}
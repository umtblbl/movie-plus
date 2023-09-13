package com.movieplus.commons.ui.extension

import android.widget.ImageView
import coil.load
import com.bumptech.glide.Glide

fun ImageView.imageUrl(url: String?) {
    Glide.with(this).load(url).into(this)
}

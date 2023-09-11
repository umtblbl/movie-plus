package com.movieplus.commons.ui.extension

import android.widget.ImageView
import coil.load

fun ImageView.imageUrl(url: String?) {
    load(url) {
        crossfade(true)
    }
}

package com.movieplus.commons.ui.extension

import androidx.recyclerview.widget.RecyclerView


fun RecyclerView.state(
    isBottomHandler: (() -> Unit)? = null,
    isRightScrollHandler: (() -> Unit)? = null,
    isLeftScrollHandler: (() -> Unit)? = null
) {
    addOnScrollListener(object : RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollVertically(1))
                isBottomHandler?.invoke()
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            if (dx > 0) {
                isRightScrollHandler?.invoke()
            } else if (dx < 0) {
                isLeftScrollHandler?.invoke()
            }
        }
    })
}

package com.daveboy.core.ext.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daveboy.core.ext.dp2px

/**
 * Add item padding for top, bottom, left, right
 */
fun RecyclerView.itemPadding(top: Int, bottom: Int = top, left: Int = top, right: Int = top) {
    addItemDecoration(PaddingItemDecoration(top, bottom, left, right))
}

class PaddingItemDecoration(top: Int, bottom: Int, left: Int, right: Int) :
    RecyclerView.ItemDecoration() {

    private val mTop = top
    private val mBottom = bottom
    private val mLeft = left
    private val mRight = right

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom = view.dp2px(mBottom)
        outRect.top = view.dp2px(mTop)
        outRect.left = view.dp2px(mLeft)
        outRect.right = view.dp2px(mRight)
    }
}

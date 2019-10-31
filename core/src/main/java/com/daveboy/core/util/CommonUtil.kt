package com.daveboy.core.util

import com.daveboy.core.InitContentProvider

fun dp2px(dp: Int): Int {
    val scale = InitContentProvider.app.resources.displayMetrics.density
    return (dp * scale + 0.5f).toInt()
}
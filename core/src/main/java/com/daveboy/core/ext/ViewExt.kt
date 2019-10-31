package com.daveboy.core.ext

import android.os.Build
import android.view.View
import android.view.ViewTreeObserver
import android.widget.EditText
import androidx.annotation.Px
import androidx.annotation.RequiresApi

/**
 * Set view visible
 */
fun View.visible() {
    visibility = View.VISIBLE
}
fun EditText.text():String{
    return this.text.toString()
}
/**
 * Set view invisible
 */
fun View.invisible() {
    visibility = View.INVISIBLE
}

/**
 * Set view gone
 */
fun View.gone() {
    visibility = View.GONE
}

/**
 * Reverse the view's visibility
 */
fun View.reverseVisibility(needGone: Boolean = true) {
    if (isVisible) {
        if (needGone) gone() else invisible()
    } else visible()
}

fun View.changeVisible(visible: Boolean, needGone: Boolean = true) {
    when {
        visible -> visible()
        needGone -> gone()
        else -> invisible()
    }
}

var View.isVisible: Boolean
    get() = visibility == View.VISIBLE
    set(value) = if (value) visible() else gone()

var View.isInvisible: Boolean
    get() = visibility == View.INVISIBLE
    set(value) = if (value) invisible() else visible()

var View.isGone: Boolean
    get() = visibility == View.GONE
    set(value) = if (value) gone() else visible()

/**
 * Set padding
 * @param size top, bottom, left, right padding are same
 */
fun View.setPadding(@Px size: Int) {
    setPadding(size, size, size, size)
}

/**
 * Register a callback to be invoked when the global layout state or the visibility of views
 * within the view tree changes
 *
 * @param callback The callback() to be invoked
 */
inline fun View.onGlobalLayout(crossinline callback: () -> Unit) = with(viewTreeObserver) {
    addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
        override fun onGlobalLayout() {
            removeOnGlobalLayoutListener(this)
            callback()
        }
    })
}

/**
 * Register a callback to be invoked after the view is measured
 *
 * @param callback The callback() to be invoked
 */
inline fun View.afterMeasured(crossinline callback: View.() -> Unit) {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
        override fun onGlobalLayout() {
            if (measuredWidth > 0 && measuredHeight > 0) {
                viewTreeObserver.removeOnGlobalLayoutListener(this)
                callback()
            }
        }
    })
}

var clickCount = 0
var lastClickTime = 0L

/**
 * Invoke the [action] after click [count] times.
 * The interval between two clicks is less than [interval] mills
 */
fun View.clickN(count: Int = 1, interval: Long = 1000, action: () -> Unit) {

    setOnClickListener {
        val currentTime = System.currentTimeMillis()
        if (lastClickTime != 0L && (currentTime - lastClickTime > interval)) {
            clickCount = 1
            lastClickTime = currentTime
            return@setOnClickListener
        }

        ++clickCount
        lastClickTime = currentTime

        if (clickCount == count) {
            clickCount = 0
            lastClickTime = 0L
            action()
        }
    }
}
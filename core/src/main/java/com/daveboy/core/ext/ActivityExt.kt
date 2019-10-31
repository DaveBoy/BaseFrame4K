package com.daveboy.core.ext

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.io.Serializable

inline fun <reified T : Activity> Activity.startActivityExt( vararg extras: Pair<String, Any?>) {
    startActivity(Intent(this, T::class.java).apply {
        putParams(*extras)
    })
}

/**
 * for the string(most use) default is null
 */
fun Activity.intentDataString(key: String, default: String?="" ):Lazy<String?> = lazy{intent?.extras?.getString(key) ?: default}
/**
 * for the default is not null
 */
fun <T:Any>Activity.intentData(key: String, default: T ):Lazy<T> = lazy{
    val value=intent?.extras?.let {
        when (default) {
            is Bundle -> it.getBundle(key)

            is Boolean -> it.getBoolean(key,default)
            is BooleanArray -> it.getBooleanArray(key)
            is Byte -> it.getByte(key,default)
            is ByteArray -> it.getByteArray(key)
            is Char -> it.getChar(key,default)
            is CharArray -> it.getCharArray(key)
            is String -> it.getString(key,default)
            is CharSequence -> it.getCharSequence(key,default)
            is Double -> it.getDouble(key,default)
            is DoubleArray -> it.getDoubleArray(key)
            is Float -> it.getFloat(key,default)
            is FloatArray -> it.getFloatArray(key)
            is Int -> it.getInt(key,default)
            is IntArray -> it.getIntArray(key)
            is Long -> it.getLong(key,default)
            is LongArray -> it.getLongArray(key)
            is Short -> it.getShort(key,default)
            is ShortArray -> it.getShortArray(key)
            is Parcelable -> it.getParcelable(key)
            is Serializable -> it.getSerializable(key)
            else -> {
                throw IllegalArgumentException("Not found $key ..")
            }
        }
    }
    (value as? T)?:default
}
fun Intent.putParams(
    vararg extras: Pair<String, Any?>
): Intent {
    if (extras.isEmpty()) return this
    extras.forEach { (key, value) ->
        value ?: let {
            it.putExtra(key, it.toString())
            return@forEach
        }
        when (value) {
            is Bundle -> this.putExtra(key, value)
            is Boolean -> this.putExtra(key, value)
            is BooleanArray -> this.putExtra(key, value)
            is Byte -> this.putExtra(key, value)
            is ByteArray -> this.putExtra(key, value)
            is Char -> this.putExtra(key, value)
            is CharArray -> this.putExtra(key, value)
            is String -> this.putExtra(key, value)
            is CharSequence -> this.putExtra(key, value)
            is Double -> this.putExtra(key, value)
            is DoubleArray -> this.putExtra(key, value)
            is Float -> this.putExtra(key, value)
            is FloatArray -> this.putExtra(key, value)
            is Int -> this.putExtra(key, value)
            is IntArray -> this.putExtra(key, value)
            is Long -> this.putExtra(key, value)
            is LongArray -> this.putExtra(key, value)
            is Short -> this.putExtra(key, value)
            is ShortArray -> this.putExtra(key, value)
            is Parcelable -> this.putExtra(key, value)
            is Serializable -> this.putExtra(key, value)
            else -> {
                throw IllegalArgumentException("Not support $value type ${value.javaClass}..")
            }
        }
    }
    return this
}

fun Activity.hideKeyboard() {
    inputMethodManager?.hideSoftInputFromWindow((currentFocus ?: View(this)).windowToken, 0)
    window!!.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
    currentFocus?.clearFocus()
}

fun Activity.showKeyboard(et: EditText) {
    et.requestFocus()
    inputMethodManager?.showSoftInput(et, InputMethodManager.SHOW_IMPLICIT)
}

fun Activity.hideKeyboard(view: View) {
    inputMethodManager?.hideSoftInputFromWindow(view.windowToken, 0)
}

